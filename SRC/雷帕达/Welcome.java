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
		saveResource("支持变量.txt");
		saveDefaultConfig();
		this.config = getConfig();
		getServer().getPluginManager().registerEvents(this, this);
		getLogger().info(TextFormat.BLUE + "§e拉普达欢迎插件已经启动了");
		Server.getInstance().getLogger().info("[Rapda_Welcome] §a盗版转载此插件没爹没妈，§b请认证作者是§e半藏§fQQ：2934731631");
	}

	@Override
	public void onDisable() {
		getLogger().info(getName() + "§e拉普达欢迎插件已经关闭了");
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		getServer().getScheduler().scheduleDelayedTask(this, new Task() {
			@Override
			public void onRun(int i) {
				player.sendTitle(
						config.get("主标题","§6《拉普达》"),
						config.get("副标题","§a欢迎你的到来")
						.replace("%玩家名字%", player.getName())
						.replace("%换行% ", "\n"),
						config.get("渐入时间",20),
						config.get("显示时间",40),
						config.get("淡出时间",20));
				player.sendMessage(config.getString("进服消息","§a欢迎你的到来")
						.replace("%换行% ", "\n")
						.replace("%玩家名字%", player.getName()));
			}
		}, this.config.get("延迟",300));
	}
}
