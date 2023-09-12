package com.andy.jwttutorial.entity;


import lombok.*;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity						// 데이터 베이스와 1:1 매핑되는 객체
@Table(name = "`user`")		// 테이블 명
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)			//자동 증
	private Long userId;

	@Column(name = "username", length = 50, unique = true)
	private String username;

	@Column(name = "password", length = 100)
	private String password;

	@Column(name = "nickname", length = 50)
	private String nickname;

	@Column(name = "activated")
	private boolean activated;

	@ManyToMany
	@JoinTable(				// 유저 객체와 권환 객체의 다대다 관계를 일대다, 다대일 관계의 조인 테이블로 정의
		name = "user_authority",
		joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
		inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
	private Set<Authority> authorities;
}
