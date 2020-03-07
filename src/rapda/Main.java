package rapda;

import java.io.File;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.item.Item;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;

public class Main extends PluginBase implements Listener{
@Override
public void onEnable() {
	// TODO 自动生成的方法存根
	super.onEnable();
	this.getLogger().info(TextFormat.BLUE+"§e拉普达欢迎插件已经启动了");
	getLogger().info(getName()+"启动§e拉普达欢迎插件中");
	getServer().getPluginManager().registerEvents(this, this);
	if(!getDataFolder().exists())
		getDataFolder().mkdirs();
	Config config=new Config(new File(getDataFolder(),"Config.yml"),Config.YAML);
	if (!config.exists("主标题"))
		config.set("主标题", "§6《拉普达》");
	if (!config.exists("副标题"))
		config.set("副标题", "§a欢迎你的到来");
	if (!config.exists("延迟"))
		config.set("延迟", 5000);
	config.save();
	config.save();
}

@Override
	public void onLoad() {
		// TODO 自动生成的方法存根
		super.onLoad();
		getLogger().info(getName()+"加载§e拉普达欢迎插件中");
	}
@Override
	public void onDisable() {
		// TODO 自动生成的方法存根
		super.onDisable();
		getLogger().info(getName()+"关闭加载");
	}

@EventHandler
public void onJoin(PlayerJoinEvent event) {
	    new Thread() {
	    public void run() {
	    sleep(getConfig().getString("延迟"));
		Player player = event.getPlayer();
		Config config=new Config(new File(getDataFolder(),"Config.yml"),Config.YAML);
		player.sendTitle(config.getString("主标题"),config.getString("副标题"));
		player.sendMessage("欢迎来到一个神奇的服务器");
		player.getInventory().clearAll();
		//id,特殊值,数量
		Item item1=Item.get(46,0,999,null);
		player.getInventory().addItem(item1);
	    }

		private void sleep(String string) {
			// TODO 自动生成的方法存根
			
		};
	    }.start();
	}
}