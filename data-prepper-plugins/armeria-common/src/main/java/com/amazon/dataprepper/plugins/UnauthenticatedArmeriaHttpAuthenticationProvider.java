/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package com.amazon.dataprepper.plugins;

import com.amazon.dataprepper.armeria.authentication.ArmeriaHttpAuthenticationProvider;
import com.amazon.dataprepper.model.annotations.DataPrepperPlugin;
import com.linecorp.armeria.server.ServerBuilder;

/**
 * The plugin to use for unauthenticated access to Armeria servers. It
 * disables authentication on endpoints.
 *
 * @since 1.2
 */
@DataPrepperPlugin(name = ArmeriaHttpAuthenticationProvider.UNAUTHENTICATED_PLUGIN_NAME, pluginType = ArmeriaHttpAuthenticationProvider.class)
public class UnauthenticatedArmeriaHttpAuthenticationProvider implements ArmeriaHttpAuthenticationProvider {
    @Override
    public void addAuthenticationDecorator(final ServerBuilder serverBuilder) {
    }
}
