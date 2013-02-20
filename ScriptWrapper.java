package GDKPro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.powerbot.core.event.events.MessageEvent;
import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.util.Timer;

public abstract class ScriptWrapper extends org.powerbot.core.script.ActiveScript {
	
	public final Timer runTime;
	private Tree jobContainer = null;
	private List<Node> jobs;
	
	
	public ScriptWrapper() {
		runTime = new Timer(0);
		jobs = Collections.synchronizedList(new ArrayList<Node>());
	}
	
	public final void provide(final Node job) {
		if(!jobs.contains(job)) {
			jobs.add(job);
			jobContainer = new Tree(jobs.toArray(new Node[jobs.size()]));
		}
	}
	
	public final void revoke(final Node job) {
		if(jobs.contains(job)) {
			jobs.remove(job);
			jobContainer = new Tree(jobs.toArray(new Node[jobs.size()]));
		}
	}
	
	public final void submit(final Task task) {
		getContainer().submit(task);
	}
	
	public final ScriptWrapper getScriptWrapper() {
		return this;
	}

	public abstract void onStart();
	
	@Override
	public int loop() {
		if (!Walking.isRunEnabled()) {
			if (Walking.getEnergy() > 40) {
				Walking.setRun(true);
			}
		}
		
		if (jobContainer != null) {
			final Node job = jobContainer.state();
			if (job != null) {
				jobContainer.set(job);
				getContainer().submit(job);
				job.join();
			}
		}
		return 0;
	}
}