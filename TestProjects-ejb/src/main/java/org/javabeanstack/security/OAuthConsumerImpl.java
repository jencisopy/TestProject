/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javabeanstack.security;

import org.javabeanstack.data.services.IAppCompanySrv;
import org.javabeanstack.model.IAppAuthConsumer;
import org.javabeanstack.model.IAppAuthConsumerToken;

/**
 *
 * @author Jorge Enciso
 */
public class OAuthConsumerImpl extends OAuthConsumerBase {
    @Override
    public Class<IAppAuthConsumer> getAuthConsumerClass() {
        try {
            return (Class<IAppAuthConsumer>) Class.forName("org.javabeanstack.model.appcatalog.AppAuthConsumer");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public Class<IAppAuthConsumerToken> getAuthConsumerTokenClass() {
        try {
            return (Class<IAppAuthConsumerToken>) Class.forName("org.javabeanstack.model.appcatalog.AppAuthConsumerToken");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
