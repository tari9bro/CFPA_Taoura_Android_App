package com.cfpa.taoura;



import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.cfpa.taoura.Fragments.Explore;
import com.github.hariprasanths.floatingtoast.FloatingToast;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;

public class  MainActivity extends AppCompatActivity {

    NavController navController;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    AppBarConfiguration appBarConfiguration;
    BottomNavigationView bottomNavigationView;
    ActionBarDrawerToggle toggle;
    public  int[] buttommenu = new int[]{R.id.Explore, R.id.Settings};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        if (navController != null) {
            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
            NavigationUI.setupWithNavController(navigationView, navController);
            NavigationUI.setupWithNavController(bottomNavigationView, navController);
        }
        bottomNavigationView.setItemIconTintList(null);

       
       


        


       

        
    navigationView.setNavigationItemSelectedListener(menuItem -> {

            if (menuItem.getItemId() == R.id.a1) {
               switchlogic(R.string.link1);

              


            }
            if (menuItem.getItemId() == R.id.a2) {
                switchlogic(R.string.link2);
                


            }
            if (menuItem.getItemId() == R.id.a3) {
                switchlogic( R.string.link3);
                
                
            }
            if (menuItem.getItemId() == R.id.a4) {
                switchlogic( R.string.link4);
                
                

            }
            if (menuItem.getItemId() == R.id.a5) {
                switchlogic( R.string.link5);
                
                

            }
        if (menuItem.getItemId() == R.id.a6) {
            switchlogic( R.string.link6);



        }
        if (menuItem.getItemId() == R.id.a7) {
            switchlogic( R.string.link7);



        }
        if (menuItem.getItemId() == R.id.a8) {
            switchlogic( R.string.link8);



        }

        if (menuItem.getItemId() == R.id.a9) {
            switchlogic( R.string.link9);



        }
        if (menuItem.getItemId() == R.id.a10) {
            switchlogic( R.string.link10);



        }
        if (menuItem.getItemId() == R.id.a11) {
            switchlogic( R.string.link11);



        }
        if (menuItem.getItemId() == R.id.a12) {
            switchlogic( R.string.link12);



        }
        if (menuItem.getItemId() == R.id.a13) {
            switchlogic( R.string.link13);



        }
        if (menuItem.getItemId() == R.id.a14) {
            switchlogic( R.string.link14);



        }
            return false;
        });
    }




    public void loadweurl(int msg) {
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.main);
        if (navHostFragment != null) {
            Fragment currentFragment = navHostFragment.getChildFragmentManager().getPrimaryNavigationFragment();
            if (currentFragment instanceof Explore) {
                WebView webview = ((Explore) currentFragment).getwebview();
                if (webview != null) {
                    String str = "<meta content=\"width=device-width, initial-scale=1, user-scalable=no\" name=\"viewport\" /><link rel=\"stylesheet\" type=\"text/css\" href=\"assets/css/main.css\" /><link href=\"assets/css/noscript.css\" rel=\"stylesheet\" />" + getString(msg);
                    webview.loadDataWithBaseURL("file:///android_asset/", str, "text/html", "UTF-8", null);
                }
            }
        }
    }

    private void init() {
        drawerLayout = findViewById(R.id.drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.navmenu);
        navigationView.setItemIconTintList(null);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        toggle.setDrawerSlideAnimationEnabled(true);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        bottomNavigationView = findViewById(R.id.bottomNavigation);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.main);
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }

        appBarConfiguration = new AppBarConfiguration.Builder(buttommenu).setOpenableLayout(drawerLayout).build();


    }



    public void switchlogic( int url) {
        loadweurl(url);
        drawerLayout.closeDrawer(GravityCompat.START);

    }





   



    
   
    public void greattoast(Activity activity, String text) {
        FloatingToast.makeToast(activity, text, FloatingToast.LENGTH_MEDIUM)
                .setFadeOutDuration(FloatingToast.FADE_DURATION_LONG)
                .setTextSizeInDp(25)
                .setGravity(FloatingToast.GRAVITY_MID_TOP)
                .setFloatDistance(FloatingToast.DISTANCE_LONG)
                .setTextColor(Color.parseColor("#E1B530"))
                .show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (navController != null) {
            return NavigationUI.navigateUp(navController, appBarConfiguration)
                    || super.onSupportNavigateUp();
        }
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {

        super.onResume();
    }


}
