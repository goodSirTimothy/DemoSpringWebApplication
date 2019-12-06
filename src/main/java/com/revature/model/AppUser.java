package com.revature.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "app_user")
public class AppUser implements UserDetails {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "enabled")
  private boolean enabled;

  @Column(name = "accountNonExpired")
  private boolean accountNonExpired;

  @Column(name = "accountNonLocked")
  private boolean accountNonLocked;

  @Column(name = "credentialsNonExpired")
  private boolean credentialsNonExpired;

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Set<ApplicationAuthority> authorities;

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Todo> todos;

  @OneToOne(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private UserInformation userInformation;

  @OneToMany(mappedBy = "createdBy", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private List<Message> messages;

  public AppUser() {
  }

  public AppUser(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public boolean isAccountNonExpired() {
    return accountNonExpired;
  }

  public void setAccountNonExpired(boolean accountNonExpired) {
    this.accountNonExpired = accountNonExpired;
  }

  public boolean isAccountNonLocked() {
    return accountNonLocked;
  }

  public void setAccountNonLocked(boolean accountNonLocked) {
    this.accountNonLocked = accountNonLocked;
  }

  public boolean isCredentialsNonExpired() {
    return credentialsNonExpired;
  }

  public void setCredentialsNonExpired(boolean credentialsNonExpired) {
    this.credentialsNonExpired = credentialsNonExpired;
  }

  public Set<ApplicationAuthority> getAuthorities() {
    return authorities;
  }


  /* @author: Hao Shen
   * authorities is a SET. No need to declare it as Collection in the input then
   * convert it back as SET.
   * Actually, no need to over load this function at all.
   */
//	public void setAuthorities(Collection<ApplicationAuthority> authorities) {	  
//	  this.authorities = authorities.stream().collect(Collectors.toSet());
//		for (ApplicationAuthority authority : authorities) {
//			authority.setUser(this);
//		}
//	}

  public List<Todo> getTodos() {
    return todos;
  }

  public void setTodos(List<Todo> todos) {
    this.todos = todos;
  }

  public UserInformation getUserInformation() {
    return userInformation;
  }

  public void setUserInformation(UserInformation userInformation) {
    this.userInformation = userInformation;
  }

  public void setAuthorities(Set<ApplicationAuthority> authorities) {
    this.authorities = authorities;
  }

  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNonExpired, accountNonLocked, authorities, credentialsNonExpired,
        enabled, password, username);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof AppUser)) {
      return false;
    }
    AppUser other = (AppUser) obj;
    return accountNonExpired == other.accountNonExpired
        && accountNonLocked == other.accountNonLocked
        && Objects.equals(authorities, other.authorities)
        && credentialsNonExpired == other.credentialsNonExpired && enabled == other.enabled
        && Objects.equals(password, other.password) && Objects.equals(username, other.username);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("AppUser [username=");
    builder.append(username);
    builder.append(", password=");
    builder.append(password);
    builder.append(", enabled=");
    builder.append(enabled);
    builder.append(", accountNonExpired=");
    builder.append(accountNonExpired);
    builder.append(", accountNonLocked=");
    builder.append(accountNonLocked);
    builder.append(", credentialsNonExpired=");
    builder.append(credentialsNonExpired);
    builder.append(", authorities=");
    builder.append(authorities);
    builder.append("]");
    return builder.toString();
  }

}
