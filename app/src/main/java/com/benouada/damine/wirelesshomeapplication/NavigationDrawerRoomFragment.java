//package com.benouada.damine.wirelesshomeapplication;
//
//
//import android.content.Context;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.ActionBarDrawerToggle;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.Toolbar;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//*
// * A simple {@link Fragment} subclass.
//
//
//public class NavigationDrawerRoomFragment extends Fragment {
//
//    private RecyclerView recyclerView;
//    public static final String PREF_FILE_NAME = "testpref";
//    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";
//    private ActionBarDrawerToggle mDrawerToggle;
//    private DrawerLayout mDrawerLayout;
//    private NavigationDrawerRoomFragmentAdapter adapter;
//    private boolean mUserLearnedDrawer;
//    private boolean mFromSavedInstanceState;
//    private View containerView;
//    public NavigationDrawerRoomFragment() {
//        // Required empty public constructor
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mUserLearnedDrawer = Boolean.valueOf(readFromPerformences(getActivity(), KEY_USER_LEARNED_DRAWER,"false" ));
//        if(savedInstanceState != null){
//            mFromSavedInstanceState = true;
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//
//        View layout = inflater.inflate(R.layout.fragment_room_navigation_drawer, container, false);
//        recyclerView = (RecyclerView) layout.findViewById(R.id.drawerList);
//        adapter = new NavigationDrawerRoomFragmentAdapter(getActivity(),getData());
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        return layout;
//    }
//
//    public static List<ViewHolderRoomItem> getData(){
//        List<ViewHolderRoomItem> data = new ArrayList<>();
//        int[] icons = {R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
//        String[] titles = {"med","amine","ben","ouada","med","amine","ben","ouada","end"};
//
//        for(int i=0 ; i<icons.length && i<titles.length ; i++){
//            ViewHolderRoomItem current = new ViewHolderRoomItem();
//            current.iconId = icons[i];
//            current.title  = titles[i];
//            data.add(current);
//        }
//        return data;
//    }
//
//    public void setUp(int fragmentId, DrawerLayout drawerLayout, Toolbar toolbar) {
//        containerView = getActivity().findViewById(fragmentId);
//        mDrawerLayout = drawerLayout;
//        mDrawerToggle = new ActionBarDrawerToggle(getActivity(),drawerLayout,toolbar, R.string.drawer_open, R.string.drawer_close){
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                super.onDrawerOpened(drawerView);
//                if (mUserLearnedDrawer){
//                    mUserLearnedDrawer = true;
//                    saveToPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, mUserLearnedDrawer+"");
//                }
//                getActivity().invalidateOptionsMenu();
//            }
//
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                super.onDrawerClosed(drawerView);
//                getActivity().invalidateOptionsMenu();
//            }
//        };
//        if(!mUserLearnedDrawer && !mFromSavedInstanceState){
//            mDrawerLayout.openDrawer(containerView);
//        }
//        mDrawerLayout.setDrawerListener(mDrawerToggle);
//    }
//
//    public static void saveToPreferences(Context context, String preferenceName, String preferenceValue){
//        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString(preferenceName, preferenceValue);
//        editor.apply();
//    }
//    public static String readFromPerformences(Context context, String preferenceName, String defaultVaalue){
//        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
//        return sharedPreferences.getString(preferenceName, defaultVaalue);
//    }
//}
