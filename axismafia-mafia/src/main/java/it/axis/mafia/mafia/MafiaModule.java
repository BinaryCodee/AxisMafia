package it.axis.mafia.mafia;

import it.axis.mafia.core.command.AxisCommandManager;
import it.axis.mafia.core.module.AxisModule;
import it.axis.mafia.mafia.command.CreateCommand;
import it.axis.mafia.mafia.command.DisbandCommand;
import it.axis.mafia.mafia.listener.MafiaListener;
import it.axis.mafia.mafia.manager.MafiaManager;
import it.axis.mafia.mafia.infrastructure.persistence.sqlite.SqliteMafiaRepository;
import it.axis.mafia.storage.connection.ConnectionFactory;
import org.bukkit.plugin.java.JavaPlugin;

public class MafiaModule implements AxisModule {
    private final JavaPlugin plugin;
    private final ConnectionFactory connectionFactory;
    private MafiaManager mafiaManager;

    public MafiaModule(JavaPlugin plugin, ConnectionFactory connectionFactory) {
        this.plugin = plugin;
        this.connectionFactory = connectionFactory;
    }

    @Override
    public String getName() {
        return "AxisMafia-Mafia";
    }

    @Override
    public boolean isCritical() {
        return true;
    }

    @Override
    public void enable() {
        SqliteMafiaRepository repo = new SqliteMafiaRepository(connectionFactory);
        mafiaManager = new MafiaManager(plugin, repo);
        mafiaManager.onEnable();

        AxisCommandManager cmdManager = new AxisCommandManager();
        plugin.getCommand("mafia").setExecutor(cmdManager);
        plugin.getCommand("mafia").setTabCompleter(cmdManager);

        cmdManager.registerSubCommand(new CreateCommand(mafiaManager));
        cmdManager.registerSubCommand(new DisbandCommand(mafiaManager));

        plugin.getServer().getPluginManager().registerEvents(new MafiaListener(), plugin);
    }

    @Override
    public void disable() {
        if (mafiaManager != null)
            mafiaManager.onDisable();
    }
}
