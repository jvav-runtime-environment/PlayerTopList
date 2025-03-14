package cn.JvavRE.playerTopList.ui;


import cn.JvavRE.playerTopList.config.Config;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;

import java.util.ArrayList;
import java.util.List;

public class PageMgr {
    private static final List<String> contents = new ArrayList<>();

    public static void updatePages(List<String> components){
        contents.clear();
        contents.addAll(components);
    }

    public static int getTotalPage(){
        return (contents.size() + Config.getPageSize() - 1) / Config.getPageSize();
    }

    public static String getPage(int page){
        // 分页计算
        int pageSize = Config.getPageSize();
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, contents.size());
        int totalPage = getTotalPage();

        StringBuilder builder = new StringBuilder();
        for (int i = start; i < end; i++) {
            builder.append(contents.get(i)).append("<newline>");
        }

        return builder.toString();
    }
}
