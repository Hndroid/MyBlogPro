package com.test.testvolley;

import java.util.List;

/**
 * Created by null on 17-10-20.
 */

public class AndroidBean {

    /**
     * error : false
     * results : [{"_id":"59e6e601421aa90fe50c017c","createdAt":"2017-10-18T13:26:25.243Z","desc":"轻量级 Android Socket 通信框架。","publishedAt":"2017-10-20T10:26:24.673Z","source":"chrome","type":"Android","url":"https://github.com/xuuhaoo/OkSocket","used":true,"who":"代码家"},{"_id":"59e948c6421aa90fe2f02bd1","createdAt":"2017-10-20T08:52:22.906Z","desc":"图文并茂全面总结Android Studio好用的插件(IDE通用)","images":["http://img.gank.io/3a2dfc7c-f579-409b-86c5-1e94ecddeba9"],"publishedAt":"2017-10-20T10:26:24.673Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/269a48d7508d","used":true,"who":"阿韦"},{"_id":"59de2f22421aa90fe50c015c","createdAt":"2017-10-11T22:48:02.721Z","desc":"用 Kotlin 实现的基于物理的动画","images":["http://img.gank.io/58925abb-3e11-4d6e-9e44-a4567c03d03f"],"publishedAt":"2017-10-17T13:10:43.731Z","source":"web","type":"Android","url":"https://github.com/sagar-viradiya/AndroidPhysicsAnimation","used":true,"who":" Thunder Bouble"},{"_id":"59e46c6a421aa90fe50c0174","createdAt":"2017-10-16T16:23:06.637Z","desc":"Android 通用圆角布局，快速实现圆角需求。","images":["http://img.gank.io/4d9b99ba-cc97-4ef8-b834-477ad8a97100"],"publishedAt":"2017-10-17T13:10:43.731Z","source":"web","type":"Android","url":"https://github.com/GcsSloop/rclayout","used":true,"who":"sloop"},{"_id":"59e46c89421aa90fe7253598","createdAt":"2017-10-16T16:23:37.313Z","desc":"Android 加密工具包。","publishedAt":"2017-10-17T13:10:43.731Z","source":"web","type":"Android","url":"https://github.com/GcsSloop/encrypt","used":true,"who":"sloop"},{"_id":"59e55ecd421aa90fe725359c","createdAt":"2017-10-17T09:37:17.526Z","desc":"一个用 Kotlin 写的轻量级 URL 路由器框架","publishedAt":"2017-10-17T13:10:43.731Z","source":"web","type":"Android","url":"https://github.com/twocity/linker","used":true,"who":"ZhangTitanjum"},{"_id":"59e5740f421aa90fe725359f","createdAt":"2017-10-17T11:07:59.933Z","desc":"Android面试指南：我们需要怎样的工程师，我们需要成为怎样的工程师？","publishedAt":"2017-10-17T13:10:43.731Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzU4MjAzNTAwMA==&mid=2247483781&idx=2&sn=c5ef46cea309df058d2b168fada6dec0&chksm=fdbf32d2cac8bbc4b7f373c76bfc4d2447717634fdbc5afae565cca92551bfd152b329d5e103#rd","used":true,"who":null},{"_id":"59df3eac421aa90fef20347c","createdAt":"2017-10-12T18:06:36.692Z","desc":"文章中详实说明利用Cmake构造Ndk库需要注意的问题，以及部分Cmake命令的解读。","publishedAt":"2017-10-16T12:19:20.311Z","source":"web","type":"Android","url":"http://blog.csdn.net/qq_34902522/article/details/78144127","used":true,"who":null},{"_id":"59e1b47b421aa90fef203481","createdAt":"2017-10-14T14:53:47.998Z","desc":"详细介绍java垃圾回收的过程及相关算法","publishedAt":"2017-10-16T12:19:20.311Z","source":"chrome","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwODI3MTc2Ng==&mid=2649647405&idx=1&sn=46a48cedd1540a994cd316ca164e005a&chksm=8f1f69d4b868e0c25245676ac55dc8d1fcad3dfa4bc63a2e0835b0a1155f1d2320a45a7c7078#rd","used":true,"who":"技术特工队"},{"_id":"59e4092c421aa90fe50c016d","createdAt":"2017-10-16T09:19:40.793Z","desc":"几条小经验帮你美化你的GitHub开源项目","publishedAt":"2017-10-16T12:19:20.311Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247487344&idx=1&sn=744a9ebc0425fb3fa17c3f62eb59e421","used":true,"who":"陈宇明"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 59e6e601421aa90fe50c017c
         * createdAt : 2017-10-18T13:26:25.243Z
         * desc : 轻量级 Android Socket 通信框架。
         * publishedAt : 2017-10-20T10:26:24.673Z
         * source : chrome
         * type : Android
         * url : https://github.com/xuuhaoo/OkSocket
         * used : true
         * who : 代码家
         * images : ["http://img.gank.io/3a2dfc7c-f579-409b-86c5-1e94ecddeba9"]
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
