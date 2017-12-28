package team.ruike.cim.pojo;

import java.util.Date;

/**
 * 群聊信息记录
 */
public class Chat {
  private Integer chatId;
  private User user;
  private String message;
  private Integer status;
  private Date date;

  public Integer getChatId() {
    return chatId;
  }

  public void setChatId(Integer chatId) {
    this.chatId = chatId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }
}
