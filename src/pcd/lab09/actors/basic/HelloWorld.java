package pcd.lab09.actors.basic;

import akka.actor.typed.*;
import akka.actor.typed.javadsl.*;

public class HelloWorld extends AbstractBehavior<HelloWorld.Greet> {

	public static final class Greet {
		public final String whom;
		public final ActorRef<Greeted> replyTo;

		public Greet(String whom, ActorRef<Greeted> replyTo) {
			this.whom = whom;
			this.replyTo = replyTo;
		}
	}

	public static final class Greeted {
		public final String whom;
		public final ActorRef<Greet> from;

		public Greeted(String whom, ActorRef<Greet> from) {
			this.whom = whom;
			this.from = from;
		}
	}

	public static Behavior<Greet> create() {
		return Behaviors.setup(HelloWorld::new);
	}

	private HelloWorld(ActorContext<Greet> context) {
		super(context);
	}

	@Override
	public Receive<Greet> createReceive() {
		return newReceiveBuilder().onMessage(Greet.class, this::onGreet).build();
	}

	private Behavior<Greet> onGreet(Greet command) {
		getContext().getLog().info("Hello {}!", command.whom);
		command.replyTo.tell(new Greeted(command.whom, getContext().getSelf()));
		return this;
	}
}