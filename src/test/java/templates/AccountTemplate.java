package templates;

import br.com.teste.model.Account;
import br.com.teste.model.AccountSituation;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.math.BigDecimal;
import java.util.UUID;

import static br.com.six2six.fixturefactory.Fixture.of;

public class AccountTemplate implements TemplateLoader {

    public static final String VALID_ACCOUNT_MODEL = UUID.randomUUID().toString();
    public static final String VALID_CONTATO_MODEL = UUID.randomUUID().toString();


    @Override
    public void load() {
        of(Account.class)
                .addTemplate(VALID_ACCOUNT_MODEL, new Rule() {{
                    add("id", 1);
                    add("agency", 1);
                    add("accountNumber", 1);
                    add("accountSituation", AccountSituation.ACTIVE);
                    add("balance", new BigDecimal(100));

                }});
    }
}
