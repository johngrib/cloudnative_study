package com.reservation.controller;

import com.reservation.common.GitRepositoryState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/git")
public class GitController {

  @Autowired
  GitRepositoryState gitRepoState;

  public GitController() { }

  @RequestMapping("/status")
  public Object checkGitRevision() {
    return gitRepoState.toString();
  }
}