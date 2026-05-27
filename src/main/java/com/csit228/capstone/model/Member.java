package com.csit228.capstone.model;

import com.csit228.capstone.enums.Role;

public class Member extends User {

  public Member() {
    setRole(Role.MEMBER);
  }

  public Member(
    int userId,
    String firstName,
    String lastName,
    String username,
    String passwordHash,
    int departmentId
  ) {
    super(
      userId,
      firstName,
      lastName,
      username,
      passwordHash,
      Role.MEMBER,
      departmentId
    );
  }


}
