package com.clock.systemui.myfirstdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.clock.systemui.myfirstdemo.hotfix.PatchManger;
import com.clock.systemui.myfirstdemo.hotfix.PatchUpdateInfo;
import com.clock.systemui.myfirstdemo.util.MAppInfoManager;
import com.clock.systemui.myfirstdemo.util.MAppManager;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainActivity extends BasePermissionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView iv = (TextView) findViewById(R.id.iv);
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        final TextView tv3 = (TextView) findViewById(R.id.tv3);
        File patchJarDir = PatchManger.globalPatchManger.get().patchFileDir.getPatchJarDir();
        tv2.setText("补丁初始化路径" + (patchJarDir != null ? patchJarDir.getAbsolutePath() : " error"));

        PatchUpdateInfo mock = PatchUpdateInfo.mock;
        if (mock.targetVersion == MAppInfoManager.getVersionCode(this) && !mock.newPatchMd5.equals(getCurrentPatchMd5())) {
            //更新patch
//            HotFixManger.updatePatchJar();
        }
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                iv.setText(user.getName());
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                tv3.setText(user.getName1());
            }
        });
    }

    /**
     * 获得当前Patch.jar Md5
     *
     * @return
     */
    private String getCurrentPatchMd5() {
        String md5 = null;
        File ff = PatchManger.globalPatchManger.get().patchFileDir.getCurrentPatchJar();
        try {
            md5 = DigestUtils.md5Hex(new FileInputStream(ff));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return md5;
    }


    @Override
    public void onBackPressed() {
        // LxApplication.exit();
        MAppManager.AppExit(this);
    }

}
