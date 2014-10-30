package android.alaride.blogreader;

public class BlogPost {
    public final String title;
    public final String url;
    public final String date;
    public final String author;

    //first step to create legitamate blog posts. getting them ready to be displayed before we connect online
    public BlogPost(String title, String url, String date, String author, String thumbnail){
        this.title = title;
        this.url = url;
        this.date = date;
        this.author = author;
    }
}
