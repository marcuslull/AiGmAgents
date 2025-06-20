package sessions;

import agents.Oratorix;
import agents.Praetor;
import com.google.adk.runner.InMemoryRunner;
import io.reactivex.rxjava3.annotations.NonNull;

public class MainSession {

    private static String SESSION_NAME = "MainSession";
    private static String SESSION_USER = "SessionUser";

    public static InMemoryRunner inMemoryRunner = new InMemoryRunner(Praetor.getAgent(), SESSION_NAME);

    public static com.google.adk.sessions.@NonNull Session session = inMemoryRunner
            .sessionService()
            .createSession(SESSION_NAME, SESSION_USER)
            .blockingGet();
}
