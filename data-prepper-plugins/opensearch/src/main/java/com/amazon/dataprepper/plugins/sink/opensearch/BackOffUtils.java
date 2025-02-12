/*
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  The OpenSearch Contributors require contributions made to
 *  this file be licensed under the Apache-2.0 license or a
 *  compatible open source license.
 *
 *  Modifications Copyright OpenSearch Contributors. See
 *  GitHub history for details.
 */

package com.amazon.dataprepper.plugins.sink.opensearch;

import org.opensearch.common.unit.TimeValue;

import java.util.Iterator;

public final class BackOffUtils {
    private final Iterator<TimeValue> iterator;

    private long currTime = 0;

    private boolean firstAttempt = true;

    public BackOffUtils(final Iterator<TimeValue> iterator) {
        this.iterator = iterator;
    }

    public boolean hasNext() {
        return firstAttempt || iterator.hasNext();
    }

    public boolean next() throws InterruptedException {
        if (firstAttempt) {
            firstAttempt = false;
            return true;
        }
        if (!iterator.hasNext()) {
            return false;
        } else {
            final long nextTime = iterator.next().getMillis();
            Thread.sleep(nextTime - currTime);
            currTime = nextTime;
            return true;
        }
    }
}
