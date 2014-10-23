package android.alaride.blogreader;

public class BlogPost {
    public final String title;
    public final String url;

    //first step to create legitamate blog posts. getting them ready to be displayed before we connect online
    public BlogPost(String title, String url){
        this.title = title;
        this.url = url;
    }
}
