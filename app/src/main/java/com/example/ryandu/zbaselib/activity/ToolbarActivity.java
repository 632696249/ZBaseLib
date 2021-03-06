package com.example.ryandu.zbaselib.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.duyangs.zbaselib.BaseActivity;
import com.duyangs.zbaselib.toast.ToastUtil;
import com.duyangs.zbaselib.toolbar.BaseToolbar;
import com.duyangs.zbaselib.util.StartActivityUtil;
import com.example.ryandu.zbaselib.R;


/**
 * <p>Project:BaseLibDemo</p>
 * <p>Package:com.duyangs.baselibdemo</p>
 * <p>Description:ToolbarActivity 演示Base</p>
 * <p>Company:</p>
 *
 * @author duyangs
 * @date 2017/04/20 0020
 */
public class ToolbarActivity extends BaseActivity implements BaseToolbar.OnClickListener {


    public static void actionStart(Context context){
        StartActivityUtil.startActivity(context,ToolbarActivity.class);
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_toobar;
    }

    @Override
    public void initParams(Bundle params) {
    }

    @Override
    protected void initView() {
        toolBarBuilder.setOnClickListener(this)
                .setTextTitle("Toolbar演示")
                .setTitleDrawable(getResources().getDrawable(R.mipmap.ic_launcher_round))
                .setTitleOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        toast("title", ToastUtil.TYPE_INFO);
                    }
                }).build();

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bar_menu,menu);
        return true;
    }

    @Override
    public void navigationOnClick(View v) {
        toast("back",ToastUtil.TYPE_INFO);
        finish();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int msg = 0;

        switch (item.getItemId()){
            case R.id.action_edit:
                msg = R.string.bar_edit;
                break;
            case R.id.action_share:
                msg = R.string.bar_share;
                break;
            case R.id.action_settings:
                msg = R.string.bar_setting;
                break;
        }
        toast(msg,ToastUtil.TYPE_INFO);
        return true;
    }
}