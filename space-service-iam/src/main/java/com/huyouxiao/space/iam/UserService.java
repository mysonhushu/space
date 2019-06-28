package com.huyouxiao.space.iam;


import com.huyouxiao.space.iam.request.SignUpRequest;

public interface UserService {
  void signUp(SignUpRequest request);
}
