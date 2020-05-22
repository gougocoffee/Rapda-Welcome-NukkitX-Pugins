package rapda;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.scheduler.Task;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;

public class Welcome extends PluginBase implements Listener{

	private Config config;

	@Override
	public void onEnable() {
		saveDefaultConfig();
		this.config = getConfig();
		getServer().getPluginManager().registerEvents(this, this);
		getLogger().info(TextFormat.BLUE + "§e拉普达欢迎插件已经启动了");
	}

	@Override
	public void onDisable() {
		getLogger().info(getName() + "已卸载");
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		getServer().getScheduler().scheduleDelayedTask(this, new Task() {
			@Override
			public void onRun(int i) {
				player.sendTitle(config.get("主标题","§6《拉普达》"),
						config.get("副标题","§a欢迎你的到来"),
						config.get("渐入时间",20),
						config.get("显示时间",40),
						config.get("淡出时间",20));
			}
		}, this.config.get("延迟",100));
	}
}