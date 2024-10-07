package dev.andrenascimento.twjobs.core.exceptions;

public class SkillNotFoundException extends ModelNotFoundException {

  public SkillNotFoundException(String message) {
    super(message);
  }

  public SkillNotFoundException() {
    super("Skill Not Found.");
  }
}
