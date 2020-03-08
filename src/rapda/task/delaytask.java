package rapda.task;

import cn.nukkit.Player;
import cn.nukkit.scheduler.Task;
import cn.nukkit.utils.Config;

public class delaytask extends Task {

    private Player player;
    private Config config;

    public delaytask(Player player, Config config) {
        this.player = player;
        this.config = config;
    }

    @Override
    public void onRun(int i) {
        this.player.sendTitle(this.config.get("主标题","§6《拉普达》"),
                this.config.get("副标题","§a欢迎你的到来"),
                this.config.get("渐入时间",20),
                this.config.get("显示时间",100),
                this.config.get("淡出时间",20));
    }
}
