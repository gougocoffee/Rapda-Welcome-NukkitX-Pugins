package rapda;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import rapda.task.delaytask;

public class Main extends PluginBase implements Listener{

	private Config config;

	@Override
	public void onEnable() {
		saveDefaultConfig();
		this.config = getConfig();
		getServer().getPluginManager().registerEvents(this, this);
		Server.getInstance().getLogger().info(TextFormat.BLUE+"§e拉普达欢迎插件已经启动了");
	}

	@Override
	public void onDisable() {
		getLogger().info(getName()+"关闭加载");
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		Server.getInstance().getScheduler().scheduleDelayedTask(
				new delaytask(player, this.config), this.config.get("延迟",100));
	}
}