package com.clock.systemui.myfirstdemo.hotfix;


import com.clock.systemui.myfirstdemo.hotfix.IPatch.IPatchDownloader;
import com.clock.systemui.myfirstdemo.hotfix.IPatch.IPatchFileDir;
import com.clock.systemui.myfirstdemo.hotfix.ImPatch.DefaultPatchDownloader;
import com.clock.systemui.myfirstdemo.hotfix.ImPatch.DefaultPatchFileDir;
import com.clock.systemui.myfirstdemo.util.Singleton;

/**
 * Created by shoyu666@163.com on 16/7/5.
 */
public class PatchManger {
    public IPatchFileDir patchFileDir;
    public IPatchDownloader patchDownloader;

    private PatchManger() {

    }


    /**
     * PatchManger Builder
     * 可以自行指定补丁的路径管理和下载管理
     */
    public static class Builder {
        IPatchFileDir patchFileDir;
        IPatchDownloader patchDownloader;

        public void setPatchFileDir(IPatchFileDir patchFileDir) {
            this.patchFileDir = patchFileDir;
        }

        public void setPatchDownloader(IPatchDownloader patchDownloader) {
            this.patchDownloader = patchDownloader;
        }

        public PatchManger build() {
            PatchManger patchManger = new PatchManger();
            initDefault();
            patchManger.patchFileDir = this.patchFileDir;
            patchManger.patchDownloader = this.patchDownloader;
            return patchManger;
        }

        private void initDefault() {
            if (patchFileDir == null) {
                patchFileDir = new DefaultPatchFileDir();
            }
            if (patchDownloader == null) {
                patchDownloader = new DefaultPatchDownloader();
            }
        }
    }

    public static Singleton<PatchManger> globalPatchManger=new Singleton<PatchManger>(){
        @Override
        public PatchManger create() {
            PatchManger.Builder b = new PatchManger.Builder();
            return b.build();
        }
    };
}
