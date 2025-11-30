package com.lunaltas.dicegame.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
@Table(name = "bet")
public class Bet extends AbstractEntity<Long> {

  @NotBlank(message = "O nome é obrigatório.")
  @Column(name = "bet_name", nullable = false, length = 60)
	private String bet_name;


  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public String getName() {
    return bet_name;
  }

  public void setName(String bet_name) {
    this.bet_name = bet_name;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}
