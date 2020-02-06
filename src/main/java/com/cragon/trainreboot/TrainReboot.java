package com.cragon.trainreboot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class TrainReboot extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getScheduler().scheduleSyncDelayedTask(this, () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.playSound(p.getLocation(), "jjams_reboot", 1f, 1f);
            }

            Bukkit.broadcastMessage(ChatColor.YELLOW + "짬스 마인크래프트 서버를 이용하시는 여러분들께 잠시 안내 말씀 드립니다.");
            Bukkit.broadcastMessage(ChatColor.YELLOW + "저희 서버는 쾌적한 게임 환경을 위하여 일정 시간마다 서버를 다시 시작하고 있습니다.");
            Bukkit.broadcastMessage(ChatColor.YELLOW + "현재 열차를 이용하고 계신 분께서는 가까운 역에서 하차하여 주시고, 건축을 하고 계신 분께서는 잠시 건축을 멈춰주시기 바랍니다.");
            Bukkit.broadcastMessage(ChatColor.YELLOW + "잠시 후 서버가 다시 시작될 예정입니다. 서버가 종료된 후 3~5분 뒤 다시 접속하시면 쾌적하게 게임을 즐기실 수 있습니다.");
            Bukkit.broadcastMessage(ChatColor.YELLOW + "건의 및 문의는 짬스 마인크래프트 서버 공식 디스코드에서 할 수 있으니 여러분의 많은 관심 부탁드립니다.");
            Bukkit.broadcastMessage(ChatColor.YELLOW + "저희 서버 운영진은 여러분의 즐거운 마인크래프트 활동을 위하여 더욱 노력하겠습니다.");
            Bukkit.broadcastMessage(ChatColor.YELLOW + "이제 열차 운행을 멈추고 서버를 다시 시작하도록 하겠습니다. 감사합니다.");

            restart();
        }, 8 * 60 * 60 * 20L);
    }

    private void restart() {
        Bukkit.getScheduler().scheduleSyncDelayedTask(this, () -> {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "train destroyall");
        }, 50 * 20L);


        Bukkit.getScheduler().scheduleSyncDelayedTask(this, () -> {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stop");
        }, 60 * 20L);
    }
}
