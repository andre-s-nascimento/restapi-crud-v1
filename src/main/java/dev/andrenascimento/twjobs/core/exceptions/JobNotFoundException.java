package dev.andrenascimento.twjobs.core.exceptions;

public class JobNotFoundException extends ModelNotFoundException{

    public JobNotFoundException(String message) {
        super(message);
    }

    public JobNotFoundException() {
        super("Job Not Found");
    }

}
