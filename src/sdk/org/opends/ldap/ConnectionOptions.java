/*
 * CDDL HEADER START
 *
 * The contents of this file are subject to the terms of the
 * Common Development and Distribution License, Version 1.0 only
 * (the "License").  You may not use this file except in compliance
 * with the License.
 *
 * You can obtain a copy of the license at
 * trunk/opends/resource/legal-notices/OpenDS.LICENSE
 * or https://OpenDS.dev.java.net/OpenDS.LICENSE.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL HEADER in each
 * file and include the License file at
 * trunk/opends/resource/legal-notices/OpenDS.LICENSE.  If applicable,
 * add the following below this CDDL HEADER, with the fields enclosed
 * by brackets "[]" replaced with your own identifying information:
 *      Portions Copyright [yyyy] [name of copyright owner]
 *
 * CDDL HEADER END
 *
 *
 *      Copyright 2009 Sun Microsystems, Inc.
 */

package org.opends.ldap;



import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;



/**
 * Common connection options for LDAP connections.
 */
public class ConnectionOptions
{
  private boolean useSSL = false;
  private TrustManager trustManager = null;
  private KeyManager keyManager = null;



  /**
   * Creates a new set of connection options with default settings. SSL
   * will not be enabled, nor will key or trust managers be defined.
   *
   * @return The new connection options.
   */
  public static ConnectionOptions defaultOptions()
  {
    return new ConnectionOptions();
  }



  // Prevent direct instantiation.
  private ConnectionOptions()
  {
    // Nothing to do.
  }



  /**
   * Creates a copy of the provided connection options.
   *
   * @param options
   *          The options to be copied.
   * @return The copy of the provided connection options.
   */
  public static ConnectionOptions copyOf(ConnectionOptions options)
  {
    return defaultOptions().setUseSSL(options.useSSL).setKeyManager(
        options.getKeyManager()).setTrustManager(
        options.getTrustManager());
  }



  /**
   * Returns the key manager which will be used for securing
   * connections.
   *
   * @return The key manager.
   */
  public KeyManager getKeyManager()
  {
    return keyManager;
  }



  /**
   * Returns the trust manager which will be used for securing
   * connections.
   *
   * @return The trust manager.
   */
  public TrustManager getTrustManager()
  {
    return trustManager;
  }



  /**
   * Sets the key manager which will be used for securing connections.
   *
   * @param keyManager
   *          The key manager which will be used for securing
   *          connections.
   * @return This connection options.
   */
  public ConnectionOptions setKeyManager(KeyManager keyManager)
  {
    this.keyManager = keyManager;
    return this;
  }



  /**
   * Sets the trust manager which will be used for securing connections.
   *
   * @param trustManager
   *          The trust manager which will be used for securing
   *          connections.
   * @return This connection options.
   */
  public ConnectionOptions setTrustManager(TrustManager trustManager)
  {
    this.trustManager = trustManager;
    return this;
  }



  /**
   * Specifies whether or not SSL should be used when connecting.
   *
   * @param useSSL
   *          {@code true} if SSL should be used when connecting,
   *          otherwise {@code false}.
   * @return This connection options.
   */
  public ConnectionOptions setUseSSL(boolean useSSL)
  {
    this.useSSL = useSSL;
    return this;
  }



  /**
   * Indicates whether or not SSL should be used when connecting.
   *
   * @return {@code true} if SSL should be used when connecting,
   *         otherwise {@code false}.
   */
  public boolean useSSL()
  {
    return useSSL;
  }

}
