# seguranca-ldap-programatica 

### No projeto na pasta resources tem as informações necessaris para configurar o projeto:

Versão do java neste exemplo: 1.6 <br/>
Servidor: jboss-as-7.1.1.Final
<br/>
* Instale o Apache Directory Studio
Baixe o Apache Directory Studio, instale, e inicie ele.
http://directory.apache.org/studio/downloads.html

* Configure o standalone.xml
No subsystem de security adicione as seguintes linhas dentro da tag <security-domains>

<security-domain name="ldap_security_domain">
    <authentication>
        <login-module code="LdapExtended" flag="required">
            <!-- Nao alterar -->
            <module-option name="java.naming.factory.initial" value="com.sun.jndi.ldap.LdapCtxFactory"/>

            <!-- Deve ser colocado o IP e porta do LDAP -->
            <module-option name="java.naming.provider.url" value="ldap://localhost:10389"/>

            <!-- Nao alterar -->
            <module-option name="java.naming.security.authentication" value="simple"/>

            <!-- Deve ser colocado o usuário admin e senha -->
            <module-option name="bindDN" value="uid=admin,ou=system"/>
            <module-option name="bindCredential" value="secret"/>

            <!-- Deve ser colocado o diretorio onde estarao os usuarios -->
            <module-option name="baseCtxDN" value="ou=system"/>

            <!-- Deve ser colocado o atributo que representa o login do usuario -->
            <module-option name="baseFilter" value="(uid={0})"/>

            <!-- Deve ser colocado o diretorio onde estara o grupo com todos os usuarios -->
            <module-option name="rolesCtxDN" value="ou=groups,ou=system"/>

            <!-- Deve ser colocado o atributo do grupo que indica quais usuarios pertencem ao grupo -->
            <module-option name="roleFilter" value="(member={1})"/>

            <!-- Nao alterar -->
            <module-option name="roleAttributeID" value="cn"/>
            <module-option name="roleRecursion" value="-1"/>
            <module-option name="throwValidateError" value="true"/>
            <module-option name="searchScope" value="ONELEVEL_SCOPE"/>
        </login-module>
    </authentication>
</security-domain>
