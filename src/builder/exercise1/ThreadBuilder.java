/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package builder.exercise1;

public class ThreadBuilder {
    private ThreadGroup threadGroup;
    private long stackSize = 0;
    private boolean inheritThreadLocals;
    private boolean daemon = false;
    private int priority = Thread.NORM_PRIORITY;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    private Runnable target;
    private String name;

    public ThreadBuilder(Runnable target, String name) {
        this.target = target;
        this.name = name;
    }

    public Thread build() {
        Thread thread = new Thread(
            this.threadGroup,
            this.target,
            this.name,
            this.stackSize,
            this.inheritThreadLocals);
        thread.setDaemon(this.daemon);
        thread.setPriority(this.priority);
        thread.setUncaughtExceptionHandler(this.uncaughtExceptionHandler);
        return thread;
    }

    public ThreadBuilder threadGroup(ThreadGroup threadGroup) {
        this.threadGroup = threadGroup;
        return this;
    }

    public ThreadBuilder stackSize(long stackSize) {
        this.stackSize = stackSize;
        return this;
    }

    public ThreadBuilder inheritThreadLocals(boolean inheritThreadLocals) {
        this.inheritThreadLocals = inheritThreadLocals;
        return this;
    }

    public ThreadBuilder daemon(boolean daemon) {
        this.daemon = daemon;
        return this;
    }

    public ThreadBuilder priority(int priority) {
        this.priority = priority;
        return this;
    }

    public ThreadBuilder uncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
        return this;
    }
}
