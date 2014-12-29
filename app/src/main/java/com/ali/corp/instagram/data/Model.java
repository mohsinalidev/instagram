package com.ali.corp.instagram.data;

import java.util.List;

/**
 * Created by ali on 9/9/2014.
 */
public class Model {

    public Meta meta;
    public Pagination pagination;
    public List<DataInfo> data;


    public static class Pagination {
        public String next_url;
    }

    public static class Meta {
        public String code;
    }

    public static class DataInfo {

        public Images images;
        public List<String> tags;
        public User user;

        public static class Images {
            public Low low_resolution;
            public Thumbnail thumbnail;
            public Std standard_resolution;

            public static class Low {
                //                @DatabaseField(columnName = "lowurl")
                public String url;
                public String width;
            }

            public static class Thumbnail {
                //                @DatabaseField(columnName = "smallurl" )
                public String url;
                public String width;
            }

            public static class Std {
                //                @DatabaseField(columnName = "stdUrl")
                public String url;
                public String width;
            }

        }

        public static class User {
            public  String username;
            public  String profile_picture;
            public  String full_name;

        }

    }

}


