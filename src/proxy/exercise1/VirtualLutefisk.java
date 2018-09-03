/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */

package proxy.exercise1;

public class VirtualLutefisk implements Lutefisk {
    private Lutefisk lutefisk;
    private Lutefisk lutefisk() {
        synchronized (this) {
            if (lutefisk == null) {
                lutefisk = new RealLutefisk();
            }
        }
        return lutefisk;
    };

    public void eat() {
        lutefisk().eat();
    }
}
