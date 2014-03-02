package com.exsoloscript.player;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Achievement;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.GameMode;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.WeatherType;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.InventoryView.Property;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.Vector;

import com.exsoloscript.uhcutils.team.Team;

public class UHCPlayer implements Player {

	private Player player;

	private Team team;

	public UHCPlayer(Player player) {
		this.player = player;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getName() {
		return player.getName();
	}

	public String getDisplayName() {
		return player.getDisplayName();
	}

	public void setDisplayName(String dn) {
		player.setDisplayName(dn);
	}

	public String getPlayerListName() {
		return player.getPlayerListName();
	}

	public void setPlayerListName(String ln) {
		player.setPlayerListName(ln);
	}

	public Location getCompassTarget() {
		return player.getCompassTarget();
	}

	public InetSocketAddress getAddress() {
		return player.getAddress();
	}

	public void sendRawMessage(String param) {
		player.sendRawMessage(param);
	}

	public void kickPlayer(String reason) {
		player.kickPlayer(reason);
	}

	public void chat(String param) {
		player.chat(param);
	}

	public boolean performCommand(String param) {
		return player.performCommand(param);
	}

	public boolean isSneaking() {
		return player.isSneaking();
	}

	public void closeInventory() {
		player.closeInventory();
	}

	public Inventory getEnderChest() {
		return player.getEnderChest();
	}

	public int getExpToLevel() {
		return player.getExpToLevel();
	}

	public GameMode getGameMode() {
		return player.getGameMode();
	}

	public PlayerInventory getInventory() {
		return player.getInventory();
	}

	public ItemStack getItemInHand() {
		return player.getItemInHand();
	}

	public ItemStack getItemOnCursor() {
		return player.getItemOnCursor();
	}

	public InventoryView getOpenInventory() {
		return player.getOpenInventory();
	}

	public int getSleepTicks() {
		return player.getSleepTicks();
	}

	public boolean isBlocking() {
		return player.isBlocking();
	}

	public boolean isSleeping() {
		return player.isSleeping();
	}

	public InventoryView openEnchanting(Location arg0, boolean arg1) {
		return player.openEnchanting(arg0, arg1);
	}

	public InventoryView openInventory(Inventory arg0) {
		return player.openInventory(arg0);
	}

	public void openInventory(InventoryView arg0) {
		player.openInventory(arg0);
	}

	public InventoryView openWorkbench(Location arg0, boolean arg1) {
		return player.openWorkbench(arg0, arg1);
	}

	public void setGameMode(GameMode arg0) {
		player.setGameMode(arg0);
	}

	public void setItemInHand(ItemStack arg0) {
		player.setItemInHand(arg0);
	}

	public void setItemOnCursor(ItemStack arg0) {
		player.setItemOnCursor(arg0);
	}

	public boolean setWindowProperty(Property arg0, int arg1) {
		return player.setWindowProperty(arg0, arg1);
	}

	public boolean addPotionEffect(PotionEffect arg0) {
		return player.addPotionEffect(arg0);
	}

	public boolean addPotionEffect(PotionEffect arg0, boolean arg1) {
		return player.addPotionEffect(arg0, arg1);
	}

	public boolean addPotionEffects(Collection<PotionEffect> arg0) {
		return player.addPotionEffects(arg0);
	}

	public Collection<PotionEffect> getActivePotionEffects() {
		return player.getActivePotionEffects();
	}

	public boolean getCanPickupItems() {
		return player.getCanPickupItems();
	}

	public String getCustomName() {
		return player.getCustomName();
	}

	public EntityEquipment getEquipment() {
		return player.getEquipment();
	}

	public double getEyeHeight() {
		return player.getEyeHeight();
	}

	public double getEyeHeight(boolean arg0) {
		return player.getEyeHeight(arg0);
	}

	public Location getEyeLocation() {
		return player.getEyeLocation();
	}

	public Player getKiller() {
		return player.getKiller();
	}

	@Deprecated
	public List<Block> getLastTwoTargetBlocks(HashSet<Byte> arg0, int arg1) {
		return player.getLastTwoTargetBlocks(arg0, arg1);
	}

	public Entity getLeashHolder() throws IllegalStateException {
		return player.getLeashHolder();
	}

	@Deprecated
	public List<Block> getLineOfSight(HashSet<Byte> arg0, int arg1) {
		return player.getLineOfSight(arg0, arg1);
	}

	public int getMaximumAir() {
		return player.getMaximumAir();
	}

	public int getMaximumNoDamageTicks() {
		return player.getMaximumNoDamageTicks();
	}

	public int getNoDamageTicks() {
		return player.getNoDamageTicks();
	}

	public int getRemainingAir() {
		return player.getRemainingAir();
	}

	public boolean getRemoveWhenFarAway() {
		return player.getRemoveWhenFarAway();
	}

	@Deprecated
	public Block getTargetBlock(HashSet<Byte> arg0, int arg1) {
		return player.getTargetBlock(arg0, arg1);
	}

	public boolean hasLineOfSight(Entity arg0) {
		return player.hasLineOfSight(arg0);
	}

	public boolean hasPotionEffect(PotionEffectType arg0) {
		return player.hasPotionEffect(arg0);
	}

	public boolean isCustomNameVisible() {
		return player.isCustomNameVisible();
	}

	public boolean isLeashed() {
		return player.isLeashed();
	}

	public <T extends Projectile> T launchProjectile(Class<? extends T> arg0) {
		return player.launchProjectile(arg0);
	}

	public void removePotionEffect(PotionEffectType arg0) {
		player.removePotionEffect(arg0);
	}

	public void setCanPickupItems(boolean arg0) {
		player.setCanPickupItems(arg0);
	}

	public void setCustomName(String arg0) {
		player.setCustomName(arg0);
	}

	public void setCustomNameVisible(boolean arg0) {
		player.setCustomNameVisible(arg0);
	}

	public void setLastDamage(double arg0) {
		player.setLastDamage(arg0);
	}

	public boolean setLeashHolder(Entity arg0) {
		return player.setLeashHolder(arg0);
	}

	public void setMaximumAir(int arg0) {
		player.setMaximumAir(arg0);
	}

	public void setMaximumNoDamageTicks(int arg0) {
		player.setMaximumNoDamageTicks(arg0);
	}

	public void setNoDamageTicks(int arg0) {
		player.setNoDamageTicks(arg0);
	}

	public void setRemainingAir(int arg0) {
		player.setRemainingAir(arg0);
	}

	public void setRemoveWhenFarAway(boolean arg0) {
		player.setRemoveWhenFarAway(arg0);
	}

	@Deprecated
	public Arrow shootArrow() {
		return player.shootArrow();
	}

	@Deprecated
	public Egg throwEgg() {
		return player.throwEgg();
	}

	@Deprecated
	public Snowball throwSnowball() {
		return player.throwSnowball();
	}

	public boolean eject() {
		return player.eject();
	}

	public int getEntityId() {
		return player.getEntityId();
	}

	public float getFallDistance() {
		return player.getFallDistance();
	}

	public int getFireTicks() {
		return player.getFireTicks();
	}

	public EntityDamageEvent getLastDamageCause() {
		return player.getLastDamageCause();
	}

	public Location getLocation() {
		return player.getLocation();
	}

	public Location getLocation(Location arg0) {
		return player.getLocation(arg0);
	}

	public int getMaxFireTicks() {
		return player.getMaxFireTicks();
	}

	public List<Entity> getNearbyEntities(double arg0, double arg1, double arg2) {
		return player.getNearbyEntities(arg0, arg1, arg2);
	}

	public Entity getPassenger() {
		return player.getPassenger();
	}

	public Server getServer() {
		return player.getServer();
	}

	public int getTicksLived() {
		return player.getTicksLived();
	}

	public EntityType getType() {
		return player.getType();
	}

	public UUID getUniqueId() {
		return player.getUniqueId();
	}

	public Entity getVehicle() {
		return player.getVehicle();
	}

	public Vector getVelocity() {
		return player.getVelocity();
	}

	public World getWorld() {
		return player.getWorld();
	}

	public boolean isDead() {
		return player.isDead();
	}

	public boolean isEmpty() {
		return player.isEmpty();
	}

	public boolean isInsideVehicle() {
		return player.isInsideVehicle();
	}

	public boolean isValid() {
		return player.isValid();
	}

	public boolean leaveVehicle() {
		return player.leaveVehicle();
	}

	public void playEffect(EntityEffect arg0) {
		player.playEffect(arg0);
	}

	public void remove() {
		player.remove();
	}

	public void setFallDistance(float arg0) {
		player.setFallDistance(arg0);
	}

	public void setFireTicks(int arg0) {
		player.setFireTicks(arg0);
	}

	public void setLastDamageCause(EntityDamageEvent arg0) {
		player.setLastDamageCause(arg0);
	}

	public boolean setPassenger(Entity arg0) {
		return player.setPassenger(arg0);
	}

	public void setTicksLived(int arg0) {
		player.setTicksLived(arg0);
	}

	public void setVelocity(Vector arg0) {
		player.setVelocity(arg0);
	}

	public boolean teleport(Location arg0) {
		return player.teleport(arg0);
	}

	public boolean teleport(Entity arg0) {
		return player.teleport(arg0);
	}

	public boolean teleport(Location arg0, TeleportCause arg1) {
		return player.teleport(arg0, arg1);
	}

	public boolean teleport(Entity arg0, TeleportCause arg1) {
		return false;
	}

	public List<MetadataValue> getMetadata(String arg0) {
		return player.getMetadata(arg0);
	}

	public boolean hasMetadata(String arg0) {
		return player.hasMetadata(arg0);
	}

	public void removeMetadata(String arg0, Plugin arg1) {
		player.removeMetadata(arg0, arg1);
	}

	public void setMetadata(String arg0, MetadataValue arg1) {
		player.setMetadata(arg0, arg1);
	}

	public void damage(double arg0) {
		player.damage(arg0);
	}

	public void damage(double arg0, Entity arg1) {
		player.damage(arg0, arg1);
	}

	public void resetMaxHealth() {
		player.resetMaxHealth();
	}

	public void setHealth(double arg0) {
		player.setHealth(arg0);
	}

	public void setMaxHealth(double arg0) {
		player.setMaxHealth(arg0);
	}

	public PermissionAttachment addAttachment(Plugin arg0) {
		return player.addAttachment(arg0);
	}

	public PermissionAttachment addAttachment(Plugin arg0, int arg1) {
		return player.addAttachment(arg0, arg1);
	}

	public PermissionAttachment addAttachment(Plugin arg0, String arg1, boolean arg2) {
		return player.addAttachment(arg0, arg1, arg2);
	}

	public PermissionAttachment addAttachment(Plugin arg0, String arg1, boolean arg2, int arg3) {
		return player.addAttachment(arg0, arg1, arg2, arg3);
	}

	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		return player.getEffectivePermissions();
	}

	public boolean hasPermission(String arg0) {
		return player.hasPermission(arg0);
	}

	public boolean hasPermission(Permission arg0) {
		return player.hasPermission(arg0);
	}

	public boolean isPermissionSet(String arg0) {
		return player.isPermissionSet(arg0);
	}

	public boolean isPermissionSet(Permission arg0) {
		return player.isPermissionSet(arg0);
	}

	public void recalculatePermissions() {
		player.recalculatePermissions();
	}

	public void removeAttachment(PermissionAttachment arg0) {
		player.removeAttachment(arg0);
	}

	public boolean isOp() {
		return player.isOp();
	}

	public void setOp(boolean arg0) {
		player.setOp(arg0);
	}

	public void abandonConversation(Conversation arg0) {
		player.abandonConversation(arg0);
	}

	public void abandonConversation(Conversation arg0, ConversationAbandonedEvent arg1) {
		player.abandonConversation(arg0, arg1);
	}

	public void acceptConversationInput(String arg0) {
		player.acceptConversationInput(arg0);
	}

	public boolean beginConversation(Conversation arg0) {
		return player.beginConversation(arg0);
	}

	public boolean isConversing() {
		return player.isConversing();
	}

	public void sendMessage(String arg0) {
		player.sendMessage(arg0);
	}

	public void sendMessage(String[] arg0) {
		player.sendMessage(arg0);
	}

	public long getFirstPlayed() {
		return player.getFirstPlayed();
	}

	public long getLastPlayed() {
		return player.getLastPlayed();
	}

	public Player getPlayer() {
		return player.getPlayer();
	}

	public boolean hasPlayedBefore() {
		return player.hasPlayedBefore();
	}

	public boolean isBanned() {
		return player.isBanned();
	}

	public boolean isOnline() {
		return player.isOnline();
	}

	public boolean isWhitelisted() {
		return player.isWhitelisted();
	}

	public void setWhitelisted(boolean arg0) {
		player.setWhitelisted(arg0);
	}

	public Map<String, Object> serialize() {
		return player.serialize();
	}

	public Set<String> getListeningPluginChannels() {
		return player.getListeningPluginChannels();
	}

	public void sendPluginMessage(Plugin arg0, String arg1, byte[] arg2) {
		player.sendPluginMessage(arg0, arg1, arg2);
	}

	public void awardAchievement(Achievement arg0) {
		player.awardAchievement(arg0);
	}

	public boolean getAllowFlight() {
		return player.getAllowFlight();
	}

	public Location getBedSpawnLocation() {
		return player.getBedSpawnLocation();
	}

	public float getExhaustion() {
		return player.getExhaustion();
	}

	public float getExp() {
		return player.getExp();
	}

	public float getFlySpeed() {
		return player.getFlySpeed();
	}

	public int getFoodLevel() {
		return player.getFoodLevel();
	}

	public double getHealthScale() {
		return player.getHealthScale();
	}

	public int getLevel() {
		return player.getLevel();
	}

	public long getPlayerTime() {
		return player.getPlayerTime();
	}

	public long getPlayerTimeOffset() {
		return player.getPlayerTimeOffset();
	}

	public WeatherType getPlayerWeather() {
		return player.getPlayerWeather();
	}

	public float getSaturation() {
		return player.getSaturation();
	}

	public Scoreboard getScoreboard() {
		return player.getScoreboard();
	}

	public int getTotalExperience() {
		return player.getTotalExperience();
	}

	public float getWalkSpeed() {
		return player.getWalkSpeed();
	}

	public void giveExp(int arg0) {
		player.giveExp(arg0);
	}

	public void giveExpLevels(int arg0) {
		player.giveExpLevels(arg0);
	}

	public void incrementStatistic(Statistic arg0) {
		player.incrementStatistic(arg0);
	}

	public void incrementStatistic(Statistic arg0, int arg1) {
		player.incrementStatistic(arg0, arg1);
	}

	public void incrementStatistic(Statistic arg0, Material arg1) {
		player.incrementStatistic(arg0, arg1);
	}

	public void incrementStatistic(Statistic arg0, Material arg1, int arg2) {
		player.incrementStatistic(arg0, arg1, arg2);
	}

	public boolean isFlying() {
		return player.isFlying();
	}

	public boolean isHealthScaled() {
		return player.isHealthScaled();
	}

	@Deprecated
	public boolean isOnGround() {
		return player.isOnGround();
	}

	public boolean isPlayerTimeRelative() {
		return player.isPlayerTimeRelative();
	}

	public boolean isSleepingIgnored() {
		return player.isSleepingIgnored();
	}

	public boolean isSprinting() {
		return player.isSprinting();
	}

	public void loadData() {
		player.loadData();
	}

	@Deprecated
	public void playEffect(Location arg0, Effect arg1, int arg2) {
		player.playEffect(arg0, arg1, arg2);
	}

	public <T> void playEffect(Location arg0, Effect arg1, T arg2) {
		player.playEffect(arg0, arg1, arg2);
	}

	@Deprecated
	public void playNote(Location arg0, byte arg1, byte arg2) {
		player.playNote(arg0, arg1, arg2);
	}

	public void playNote(Location arg0, Instrument arg1, Note arg2) {
		player.playNote(arg0, arg1, arg2);
	}

	public void playSound(Location arg0, Sound arg1, float arg2, float arg3) {
		player.playSound(arg0, arg1, arg2, arg3);
	}

	@Deprecated
	public void playSound(Location arg0, String arg1, float arg2, float arg3) {
		player.playSound(arg0, arg1, arg2, arg3);
	}

	public void resetPlayerTime() {
		player.resetPlayerTime();
	}

	public void resetPlayerWeather() {
		player.resetPlayerWeather();
	}

	public void saveData() {
		player.saveData();
	}

	@Deprecated
	public void sendBlockChange(Location arg0, Material arg1, byte arg2) {
		player.sendBlockChange(arg0, arg1, arg2);
	}

	@Deprecated
	public void sendBlockChange(Location arg0, int arg1, byte arg2) {
		player.sendBlockChange(arg0, arg1, arg2);
	}

	@Deprecated
	public boolean sendChunkChange(Location arg0, int arg1, int arg2, int arg3, byte[] arg4) {
		return player.sendChunkChange(arg0, arg1, arg2, arg3, arg4);
	}

	public void sendMap(MapView arg0) {
		player.sendMap(arg0);
	}

	public void setAllowFlight(boolean arg0) {
		player.setAllowFlight(arg0);
	}

	public void setBedSpawnLocation(Location arg0) {
		player.setBedSpawnLocation(arg0);
	}

	public void setBedSpawnLocation(Location arg0, boolean arg1) {
		player.setBedSpawnLocation(arg0);
	}

	public void setCompassTarget(Location arg0) {
		player.setCompassTarget(arg0);
	}

	public void setExhaustion(float arg0) {
		player.setExhaustion(arg0);
	}

	public void setExp(float arg0) {
		player.setExp(arg0);
	}

	public void setFlySpeed(float arg0) throws IllegalArgumentException {
		player.setFlySpeed(arg0);
	}

	public void setFlying(boolean arg0) {
		player.setFlying(arg0);
	}

	public void setFoodLevel(int arg0) {
		player.setFoodLevel(arg0);
	}

	public void setHealthScale(double arg0) throws IllegalArgumentException {
		player.setHealthScale(arg0);
	}

	public void setHealthScaled(boolean arg0) {
		player.setHealthScaled(arg0);
	}

	public void setLevel(int arg0) {
		player.setLevel(arg0);
	}

	public void setPlayerTime(long arg0, boolean arg1) {
		player.setPlayerTime(arg0, arg1);
	}

	public void setPlayerWeather(WeatherType arg0) {
		player.setPlayerWeather(arg0);
	}

	public void setSaturation(float arg0) {
		player.setSaturation(arg0);
	}

	public void setScoreboard(Scoreboard arg0) throws IllegalArgumentException, IllegalStateException {
		player.setScoreboard(arg0);
	}

	public void setSleepingIgnored(boolean arg0) {
		player.setSleepingIgnored(arg0);
	}

	public void setSneaking(boolean arg0) {
		player.setSneaking(arg0);
	}

	public void setSprinting(boolean arg0) {
		player.setSprinting(arg0);
	}

	@Deprecated
	public void setTexturePack(String arg0) {
		player.setTexturePack(arg0);
	}

	public void setTotalExperience(int arg0) {
		player.setTotalExperience(arg0);
	}

	public void setWalkSpeed(float arg0) throws IllegalArgumentException {
		player.setWalkSpeed(arg0);
	}

	@Deprecated
	public void updateInventory() {
		player.updateInventory();
	}

	public boolean canSee(Player arg0) {
		return player.canSee(arg0);
	}

	public void hidePlayer(Player arg0) {
		player.hidePlayer(arg0);
	}

	public void setResourcePack(String arg0) {
		player.setResourcePack(arg0);
	}

	public void showPlayer(Player arg0) {
		player.showPlayer(arg0);
	}

	public double getLastDamage() {
		return ((Damageable) player).getLastDamageCause().getDamage();
	}

	public double getHealth() {
		return ((Damageable) player).getHealth();
	}

	public double getMaxHealth() {
		return ((Damageable) player).getMaxHealth();
	}

	public int _INVALID_getLastDamage() {
		return 0;
	}

	public void _INVALID_setLastDamage(int arg0) {

	}

	public void _INVALID_damage(int arg0) {

	}

	public void _INVALID_damage(int arg0, Entity arg1) {

	}

	public int _INVALID_getHealth() {
		return 0;
	}

	public int _INVALID_getMaxHealth() {
		return 0;
	}

	public void _INVALID_setHealth(int arg0) {

	}

	public void _INVALID_setMaxHealth(int arg0) {

	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> arg0, Vector arg1) {
		return this.player.launchProjectile(arg0, arg1);
	}

	@Override
	public void setBanned(boolean arg0) {

	}

	@Override
	public void decrementStatistic(Statistic arg0) throws IllegalArgumentException {
		this.player.decrementStatistic(arg0);
	}

	@Override
	public void decrementStatistic(Statistic arg0, int arg1) throws IllegalArgumentException {
		this.player.decrementStatistic(arg0, arg1);
	}

	@Override
	public void decrementStatistic(Statistic arg0, Material arg1) throws IllegalArgumentException {
		this.player.decrementStatistic(arg0, arg1);
	}

	@Override
	public void decrementStatistic(Statistic arg0, EntityType arg1) throws IllegalArgumentException {
		this.player.decrementStatistic(arg0, arg1);
	}

	@Override
	public void decrementStatistic(Statistic arg0, Material arg1, int arg2) throws IllegalArgumentException {
		this.player.decrementStatistic(arg0, arg1, arg2);
	}

	@Override
	public void decrementStatistic(Statistic arg0, EntityType arg1, int arg2) {
		this.player.decrementStatistic(arg0, arg1, arg2);
	}

	@Override
	public int getStatistic(Statistic arg0) throws IllegalArgumentException {
		return this.player.getStatistic(arg0);
	}

	@Override
	public int getStatistic(Statistic arg0, Material arg1) throws IllegalArgumentException {
		return this.player.getStatistic(arg0, arg1);
	}

	@Override
	public int getStatistic(Statistic arg0, EntityType arg1) throws IllegalArgumentException {
		return this.player.getStatistic(arg0, arg1);
	}

	@Override
	public boolean hasAchievement(Achievement arg0) {
		return this.player.hasAchievement(arg0);
	}

	@Override
	public void incrementStatistic(Statistic arg0, EntityType arg1) throws IllegalArgumentException {
		this.player.incrementStatistic(arg0, arg1);
	}

	@Override
	public void incrementStatistic(Statistic arg0, EntityType arg1, int arg2) throws IllegalArgumentException {
		this.player.incrementStatistic(arg0, arg1, arg2);
	}

	@Override
	public void removeAchievement(Achievement arg0) {
		this.player.removeAchievement(arg0);
	}

	@Override
	public void setStatistic(Statistic arg0, int arg1) throws IllegalArgumentException {
		this.player.setStatistic(arg0, arg1);
	}

	@Override
	public void setStatistic(Statistic arg0, Material arg1, int arg2) throws IllegalArgumentException {
		this.player.setStatistic(arg0, arg1, arg2);
	}

	@Override
	public void setStatistic(Statistic arg0, EntityType arg1, int arg2) {
		this.player.setStatistic(arg0, arg1, arg2);
	}

}