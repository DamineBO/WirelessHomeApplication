package com.benouada.damine.wirelesshomeapplication.api.device.lighting.util;

import android.graphics.Color;
import android.graphics.PointF;

import java.util.ArrayList;
import java.util.List;

// Color Utility Class
public class ColorUtility {

    // Colors
    private static List<PointF> colorPointsLivingColor = new ArrayList();
    private static List<PointF> colorPointsHueBulb = new ArrayList();
    private static List<PointF> colorPointsDefault = new ArrayList();
    private static final List<String> HUE_BULBS = new ArrayList();
    private static final List<String> LIVING_COLORS = new ArrayList();

    static {
        HUE_BULBS.add("LCT001");
        HUE_BULBS.add("LCT002");
        HUE_BULBS.add("LCT003");
        HUE_BULBS.add("LLM001");

        LIVING_COLORS.add("LLC001");
        LIVING_COLORS.add("LLC005");
        LIVING_COLORS.add("LLC006");
        LIVING_COLORS.add("LLC007");
        LIVING_COLORS.add("LLC010");
        LIVING_COLORS.add("LLC011");
        LIVING_COLORS.add("LLC012");
        LIVING_COLORS.add("LLC014");
        LIVING_COLORS.add("LLC013");
        LIVING_COLORS.add("LST001");

        colorPointsHueBulb.add(new PointF(0.674F, 0.322F));
        colorPointsHueBulb.add(new PointF(0.408F, 0.517F));
        colorPointsHueBulb.add(new PointF(0.168F, 0.041F));

        colorPointsLivingColor.add(new PointF(0.703F, 0.296F));
        colorPointsLivingColor.add(new PointF(0.214F, 0.709F));
        colorPointsLivingColor.add(new PointF(0.139F, 0.081F));

        colorPointsDefault.add(new PointF(1.0F, 0.0F));
        colorPointsDefault.add(new PointF(0.0F, 1.0F));
        colorPointsDefault.add(new PointF(0.0F, 0.0F));
    }

    // XY --> Color
    public static int calculateColorFromXY(float[] points, String model) {
        if ((points == null) || (model == null)) {
            throw new IllegalArgumentException(
                    "Input parameter can't be null");
        }

        PointF xy = new PointF(points[0], points[1]);
        List colorPoints = colorPointsForModel(model);
        boolean inReachOfLamps = checkPointInLampsReach(xy, colorPoints);
        if (!inReachOfLamps) {
            PointF pAB = getClosestPointToPoints((PointF) colorPoints.get(0),
                    (PointF) colorPoints.get(1), xy);
            PointF pAC = getClosestPointToPoints((PointF) colorPoints.get(2),
                    (PointF) colorPoints.get(0), xy);

            PointF pBC = getClosestPointToPoints((PointF) colorPoints.get(1),
                    (PointF) colorPoints.get(2), xy);

            float dAB = getDistanceBetweenTwoPoints(xy, pAB);
            float dAC = getDistanceBetweenTwoPoints(xy, pAC);
            float dBC = getDistanceBetweenTwoPoints(xy, pBC);
            float lowest = dAB;
            PointF closestPoint = pAB;
            if (dAC < lowest) {
                lowest = dAC;
                closestPoint = pAC;
            }
            if (dBC < lowest) {
                lowest = dBC;
                closestPoint = pBC;
            }

            xy.x = closestPoint.x;
            xy.y = closestPoint.y;
        }
        float x = xy.x;
        float y = xy.y;
        float z = 1.0F - x - y;
        float y2 = 1.0F;
        float x2 = y2 / y * x;
        float z2 = y2 / y * z;

        float r = x2 * 3.2406F - y2 * 1.5372F - z2 * 0.4986F;
        float g = -x2 * 0.9689F + y2 * 1.8758F + z2 * 0.0415F;
        float b = x2 * 0.0557F - y2 * 0.204F + z2 * 1.057F;

        if ((r > b) && (r > g) && (r > 1.0F)) {
            g /= r;
            b /= r;
            r = 1.0F;
        } else if ((g > b) && (g > r) && (g > 1.0F)) {
            r /= g;
            b /= g;
            g = 1.0F;
        } else if ((b > r) && (b > g) && (b > 1.0F)) {
            r /= b;
            g /= b;
            b = 1.0F;
        }

        r = r <= 0.0031308F ? 12.92F * r : 1.055F *
                (float) Math.pow(r, 0.416666656732559D) - 0.055F;
        g = g <= 0.0031308F ? 12.92F * g : 1.055F *
                (float) Math.pow(g, 0.416666656732559D) - 0.055F;
        b = b <= 0.0031308F ? 12.92F * b : 1.055F *
                (float) Math.pow(b, 0.416666656732559D) - 0.055F;

        if ((r > b) && (r > g)) {
            if (r > 1.0F) {
                g /= r;
                b /= r;
                r = 1.0F;
            }
        } else if ((g > b) && (g > r)) {
            if (g > 1.0F) {
                r /= g;
                b /= g;
                g = 1.0F;
            }
        } else if ((b > r) && (b > g) && (b > 1.0F)) {
            r /= b;
            g /= b;
            b = 1.0F;
        }

        if (r < 0.0F) {
            r = 0.0F;
        }
        if (g < 0.0F) {
            g = 0.0F;
        }
        if (b < 0.0F) {
            b = 0.0F;
        }

        int r1 = (int) (r * 255.0F);
        int g1 = (int) (g * 255.0F);
        int b1 = (int) (b * 255.0F);

        return Color.rgb(r1, g1, b1);
    }

    // Color --> XY
    public static float[] calculateXYFromColor(int color, String model) {
        float red = 1.0F;
        float green = 1.0F;
        float blue = 1.0F;

        red = Color.red(color) / 255.0F;
        green = Color.green(color) / 255.0F;
        blue = Color.blue(color) / 255.0F;

        float r = red > 0.04045F ? (float) Math.pow((red + 0.055F) /
                1.055F, 2.400000095367432D) :
                red / 12.92F;
        float g = green > 0.04045F ? (float) Math.pow((green + 0.055F) /
                1.055F, 2.400000095367432D) :
                green / 12.92F;
        float b = blue > 0.04045F ? (float) Math.pow((blue + 0.055F) /
                1.055F, 2.400000095367432D) :
                blue / 12.92F;

        float x = r * 0.649926F + g * 0.103455F + b * 0.197109F;
        float y = r * 0.234327F + g * 0.743075F + b * 0.022598F;
        float z = r * 0.0F + g * 0.053077F + b * 1.035763F;

        float[] xy = new float[2];

        xy[0] = (x / (x + y + z));
        xy[1] = (y / (x + y + z));
        if (Float.isNaN(xy[0])) {
            xy[0] = 0.0F;
        }
        if (Float.isNaN(xy[1])) {
            xy[1] = 0.0F;
        }

        PointF xyPoint = new PointF(xy[0], xy[1]);
        List colorPoints = colorPointsForModel(model);
        boolean inReachOfLamps = checkPointInLampsReach(xyPoint, colorPoints);
        if (!inReachOfLamps) {
            PointF pAB = getClosestPointToPoints((PointF) colorPoints.get(0),
                    (PointF) colorPoints.get(1), xyPoint);
            PointF pAC = getClosestPointToPoints((PointF) colorPoints.get(2),
                    (PointF) colorPoints.get(0), xyPoint);
            PointF pBC = getClosestPointToPoints((PointF) colorPoints.get(1),
                    (PointF) colorPoints.get(2), xyPoint);

            float dAB = getDistanceBetweenTwoPoints(xyPoint, pAB);
            float dAC = getDistanceBetweenTwoPoints(xyPoint, pAC);
            float dBC = getDistanceBetweenTwoPoints(xyPoint, pBC);

            float lowest = dAB;
            PointF closestPoint = pAB;
            if (dAC < lowest) {
                lowest = dAC;
                closestPoint = pAC;
            }
            if (dBC < lowest) {
                lowest = dBC;
                closestPoint = pBC;
            }

            xy[0] = closestPoint.x;
            xy[1] = closestPoint.y;
        }

        xy[0] = precision(xy[0]);
        xy[1] = precision(xy[1]);
        return xy;
    }

    // float precision
    public static float precision(float d) {
        return Math.round(10000.0F * d) / 10000.0F;
    }

    // RGB --> XY
    public static float[] calculateXYFromRGB(int red, int green, int blue, String model) {
        int rgb = Color.rgb(red, green, blue);
        return calculateXYFromColor(rgb, model);
    }

    // HSB --> Color
    public static int calculateColorFromHSB(int hue, int sat, int bri) {
        float huef = hueRaw(hue) / (65535.0f / 360.0f);
        float satf = sat / 255.0f;
        float brif = bri / 255.0f;
        float[] hsv = {huef, satf, brif};
        return Color.HSVToColor(hsv);
    }

    // Color -->  HSB
    public static float[] calculateHSBFromColor(int color) {
        float[] HSV = new float[3];
        Color.colorToHSV(color, HSV);
        HSV[0] = (65535.0f * hueRaw(HSV[0])) / 360.0f;
        HSV[1] = HSV[1] * 255.0f;
        HSV[2] = HSV[2] * 255.0f;
        return HSV;
    }

    // PRIVATE METHODS
    private static boolean checkPointInLampsReach(PointF point, List<PointF> colorPoints) {
        if ((point == null) || (colorPoints == null)) {
            return false;
        }
        PointF red = (PointF) colorPoints.get(0);
        PointF green = (PointF) colorPoints.get(1);
        PointF blue = (PointF) colorPoints.get(2);
        PointF v1 = new PointF(green.x - red.x, green.y - red.y);
        PointF v2 = new PointF(blue.x - red.x, blue.y - red.y);
        PointF q = new PointF(point.x - red.x, point.y - red.y);
        float s = crossProduct(q, v2) / crossProduct(v1, v2);
        float t = crossProduct(v1, q) / crossProduct(v1, v2);

        return (s >= 0.0F) && (t >= 0.0F) && (s + t <= 1.0F);
    }

    private static float getDistanceBetweenTwoPoints(PointF one, PointF two) {
        float dx = one.x - two.x;
        float dy = one.y - two.y;
        float dist = (float) Math.sqrt(dx * dx + dy * dy);

        return dist;
    }

    private static float crossProduct(PointF point1, PointF point2) {
        return point1.x * point2.y - point1.y * point2.x;
    }

    private static List<PointF> colorPointsForModel(String model) {
        if (model == null)
            model = " ";
        List colorPoints;
        if (HUE_BULBS.contains(model)) {
            colorPoints = colorPointsHueBulb;
        } else {
            if (LIVING_COLORS.contains(model))
                colorPoints = colorPointsLivingColor;
            else
                colorPoints = colorPointsDefault;
        }
        return colorPoints;
    }

    private static PointF getClosestPointToPoints(PointF pointA, PointF pointB, PointF pointP) {
        if ((pointA == null) || (pointB == null) || (pointP == null)) {
            return null;
        }
        PointF pointAP = new PointF(pointP.x - pointA.x, pointP.y - pointA.y);
        PointF pointAB = new PointF(pointB.x - pointA.x, pointB.y - pointA.y);
        float ab2 = pointAB.x * pointAB.x + pointAB.y * pointAB.y;
        float apAb = pointAP.x * pointAB.x + pointAP.y * pointAB.y;
        float t = apAb / ab2;
        if (t < 0.0F) {
            t = 0.0F;
        } else if (t > 1.0F) {
            t = 1.0F;
        }
        PointF newPoint = new PointF(pointA.x + pointAB.x * t, pointA.y +
                pointAB.y * t);
        return newPoint;
    }

    private static int hueRaw(float hue) {
        if (hue < 15834.5f)
            return Math.round(hue / 1.449668116f);

        if (hue < 25500)
            return Math.round(1.129991724f * hue - 6969.788950962f);

        if (hue < 46920)
            return Math.round(1.01984127f * hue - 4160.952380952f);

        if (hue < 56100)
            return Math.round(1.189814815f * hue - 12136.111111111f);

        return Math.round(1.157657658f * hue - 10332.094594595f);
    }
}
