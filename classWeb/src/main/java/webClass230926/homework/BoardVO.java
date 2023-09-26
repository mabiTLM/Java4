package webClass230926.homework;

public class BoardVO {
  private int idNumber;
  private String title;
  private String writer;
  private String post;
  private String date;


  public BoardVO(int idNumber, String title, String writer, String post, String date) {
    this.idNumber = idNumber;
    this.title = title;
    this.writer = writer;
    this.post = post;
    this.date = date;
  }

  public BoardVO(String title, String writer, String post) {
    this.title = title;
    this.writer = writer;
    this.post = post;
  }

  public int getIdNumber() {
    return idNumber;
  }

  public String getTitle() {
    return title;
  }

  public String getWriter() {
    return writer;
  }

  public String getPost() {
    return post;
  }

  public String getDate() {
    return date;
  }

}
