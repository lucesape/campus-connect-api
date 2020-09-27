package com.campussocialmedia.campussocialmedia.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
	private Long userId;
	private String userName;
	private String email;
	private String password;

	private String firstName;
	private String lastName;
	private String phone;
	private List<Long> personalChats;
	private List<Long> groups;

	public UserDTO(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

}
