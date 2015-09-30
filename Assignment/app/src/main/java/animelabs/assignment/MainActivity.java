package animelabs.assignment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener {
    List<String> categories;
    static final String KEY_TITLE = "title";
    static final String KEY_PHOTOS = "photo";
    ArrayList<HashMap<String,String>> data;
    ListView listView;
    CustomAdapter customAdapter;
    Toolbar toolbar;
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    DrawerLayout Drawer;
    ActionBarDrawerToggle mDrawerToggle;
    String TITLES[] = {"Messages","Photo","Friends","Music","Notifications"};
    int ICONS[] = {R.drawable.message,R.drawable.stackofphotos,R.drawable.vontacts,R.drawable.musicalnotes,R.drawable.googlealerts};
    String DATA[]={"23","43","54","334","667","23"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new MyAdapter(TITLES,ICONS,DATA);
        mRecyclerView.setAdapter(mAdapter);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Fragment frag = null;
                        if (position == 1) {
                            view.setBackgroundResource(R.drawable.listcutom);
                            Drawer.closeDrawer(Gravity.LEFT);
                            mRecyclerView.getChildAt(2).setBackgroundResource(Color.TRANSPARENT);
                            mRecyclerView.getChildAt(3).setBackgroundResource(Color.TRANSPARENT);
                            mRecyclerView.getChildAt(4).setBackgroundResource(Color.TRANSPARENT);
                            mRecyclerView.getChildAt(5).setBackgroundResource(Color.TRANSPARENT);
                        }
                        if (position == 2) {
                            view.setBackgroundResource(R.drawable.listcutom);
                            Drawer.closeDrawer(Gravity.LEFT);
                            mRecyclerView.getChildAt(1).setBackgroundResource(Color.TRANSPARENT);
                            mRecyclerView.getChildAt(3).setBackgroundResource(Color.TRANSPARENT);
                            mRecyclerView.getChildAt(4).setBackgroundResource(Color.TRANSPARENT);
                            mRecyclerView.getChildAt(5).setBackgroundResource(Color.TRANSPARENT);

                        }
                        if (position == 3) {

                            Drawer.closeDrawer(Gravity.LEFT);
                            view.setBackgroundResource(R.drawable.listcutom);
                            mRecyclerView.getChildAt(1).setBackgroundResource(Color.TRANSPARENT);
                            mRecyclerView.getChildAt(2).setBackgroundResource(Color.TRANSPARENT);
                            mRecyclerView.getChildAt(4).setBackgroundResource(Color.TRANSPARENT);
                            mRecyclerView.getChildAt(5).setBackgroundResource(Color.TRANSPARENT);
                        }
                        if (position == 4) {
                            Drawer.closeDrawer(Gravity.LEFT);
                            view.setBackgroundResource(R.drawable.listcutom);
                            mRecyclerView.getChildAt(1).setBackgroundResource(Color.TRANSPARENT);
                            mRecyclerView.getChildAt(3).setBackgroundResource(Color.TRANSPARENT);
                            mRecyclerView.getChildAt(2).setBackgroundResource(Color.TRANSPARENT);
                            mRecyclerView.getChildAt(5).setBackgroundResource(Color.TRANSPARENT);

                        }
                        if (position == 5) {
                            Drawer.closeDrawer(Gravity.LEFT);
                            view.setBackgroundResource(R.drawable.listcutom);
                            mRecyclerView.getChildAt(1).setBackgroundResource(Color.TRANSPARENT);
                            mRecyclerView.getChildAt(3).setBackgroundResource(Color.TRANSPARENT);
                            mRecyclerView.getChildAt(4).setBackgroundResource(Color.TRANSPARENT);
                            mRecyclerView.getChildAt(2).setBackgroundResource(Color.TRANSPARENT);

                        }
                    }
                })
        );
        data=new ArrayList<HashMap<String,String>>();
        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        HashMap<String,String> hashdata=new HashMap<>();
      for (int i=0;i<4;i++)
      {
          hashdata.put(KEY_TITLE,"Landscape"+i);
          hashdata.put(KEY_PHOTOS,"244 Posts"+i);
          data.add(hashdata);
      }
        // Spinner click listener

        listView=(ListView)findViewById(R.id.listView);
        customAdapter=new CustomAdapter(this,data);
        listView.setAdapter(customAdapter);
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        categories = new ArrayList<String>();
        categories.add("");
        categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.openDrawer,R.string.closeDrawer){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
              }
        };
        Drawer.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
     Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

}
