package com.taojian.shiro.start;

import sun.security.krb5.Realm;

/**
 * @description:Spring Boot Application that show the usage of a user login, checking permissions, and annotation protected methods.
 * @author: taojian
 * @create: 2019-01-03 14:54
 **/
@Configuration
@SpringBootApplication
public class StartApp { //NOPMD

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(CliApp.class, args);

        // Grab the 'QuickStart' bean, call 'run()' to start the example.
        context.getBean(QuickStart.class).run();
    }

    /**
     * Example hard coded Realm bean.
     *
     * @return hard coded Realm bean
     */
    @Bean
    public Realm realm() {
        TextConfigurationRealm realm = new TextConfigurationRealm();
        realm.setUserDefinitions("joe.coder=password,user\n" +
                "jill.coder=password,admin");

        realm.setRoleDefinitions("admin=read,write\n" +
                "user=read");
        realm.setCachingEnabled(true);
        return realm;
    }


}
