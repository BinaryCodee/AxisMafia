package it.axis.mafia.economy;

import it.axis.mafia.economy.service.EconomyServiceImpl;
import it.axis.mafia.economy.service.PizzoService;
import it.axis.mafia.economy.service.RapinaService;
import org.bukkit.plugin.java.JavaPlugin;

public class EconomyPlugin extends JavaPlugin {

    private EconomyServiceImpl economyService;
    private PizzoService pizzoService;
    private RapinaService rapinaService;
    private static EconomyPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        this.economyService = new EconomyServiceImpl();
        this.pizzoService = new PizzoService();
        this.rapinaService = new RapinaService();

        getLogger().info("AxisMafia Economy Module initialized.");
    }

    public static EconomyPlugin getInstance() {
        return instance;
    }

    public EconomyServiceImpl getEconomyService() {
        return economyService;
    }

    public PizzoService getPizzoService() {
        return pizzoService;
    }

    public RapinaService getRapinaService() {
        return rapinaService;
    }
}
