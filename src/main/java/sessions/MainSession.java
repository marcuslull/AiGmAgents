package sessions;

import agents.oratorix.Oratorix;
import com.google.adk.runner.InMemoryRunner;
import io.reactivex.rxjava3.annotations.NonNull;

public class MainSession {

    // TODO: Classify this so we can have many sessions
    private static String SESSION_NAME = "MainSession";
    private static String SESSION_USER = "SessionUser";

    public static InMemoryRunner inMemoryRunner = new InMemoryRunner(Oratorix.ORATORIX, SESSION_NAME);

    public static com.google.adk.sessions.@NonNull Session session = inMemoryRunner
            .sessionService()
            .createSession(SESSION_NAME, SESSION_USER)
            .blockingGet();

    // TODO: parameterize SESSION_NAME and SESSION_USER
}
