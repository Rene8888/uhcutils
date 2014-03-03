package com.exsoloscript.player;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
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

import com.exsoloscript.player.exception.PlayerOfflineException;
import com.exsoloscript.uhcutils.Util;
import com.exsoloscript.uhcutils.team.Team;

public class UHCPlayer implements Player, Externalizable {

	private Player player;

	private Team team;

	private UUID uuid;

	public UHCPlayer(Player player) {
		this.uuid = player.getUniqueId();
		this.player = player;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(this.uuid);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.uuid = (UUID) in.readObject();
	}

	public Player getPlayer() {
		if (this.player == null) {
			Player p = Util.getPlayerByUUID(this.uuid);
			if (p == null) {
				throw new PlayerOfflineException("the player could not be found");
			} else {
				this.player = p;
			}
		}
		return this.player;
	}

	public boolean equals(Object o) {
		if (o instanceof UHCPlayer) {
			UHCPlayer p = (UHCPlayer) o;
			return p.getUniqueId().equals(this.getUniqueId());
		} else {
			return false;
		}
	}

	public String getName() {
		return this.getPlayer().getName();
	}

	public String getDisplayName() {
		return this.getPlayer().getDisplayName();
	}

	public void setDisplayName(String dn) {
		this.getPlayer().setDisplayName(dn);
	}

	public String getPlayerListName() {
		return this.getPlayer().getPlayerListName();
	}

	public void setPlayerListName(String ln) {
		this.getPlayer().setPlayerListName(ln);
	}

	public Location getCompassTarget() {
		return this.getPlayer().getCompassTarget();
	}

	public InetSocketAddress getAddress() {
		return this.getPlayer().getAddress();
	}

	public void sendRawMessage(String param) {
		this.getPlayer().sendRawMessage(param);
	}

	public void kickPlayer(String reason) {
		this.getPlayer().kickPlayer(reason);
	}

	public void chat(String param) {
		this.getPlayer().chat(param);
	}

	public boolean performCommand(String param) {
		return this.getPlayer().performCommand(param);
	}

	public boolean isSneaking() {
		return this.getPlayer().isSneaking();
	}

	public void closeInventory() {
		this.getPlayer().closeInventory();
	}

	public Inventory getEnderChest() {
		return this.getPlayer().getEnderChest();
	}

	public int getExpToLevel() {
		return this.getPlayer().getExpToLevel();
	}

	public GameMode getGameMode() {
		return this.getPlayer().getGameMode();
	}

	public PlayerInventory getInventory() {
		return this.getPlayer().getInventory();
	}

	public ItemStack getItemInHand() {
		return this.getPlayer().getItemInHand();
	}

	public ItemStack getItemOnCursor() {
		return this.getPlayer().getItemOnCursor();
	}

	public InventoryView getOpenInventory() {
		return this.getPlayer().getOpenInventory();
	}

	public int getSleepTicks() {
		return this.getPlayer().getSleepTicks();
	}

	public boolean isBlocking() {
		return this.getPlayer().isBlocking();
	}

	public boolean isSleeping() {
		return this.getPlayer().isSleeping();
	}

	public InventoryView openEnchanting(Location arg0, boolean arg1) {
		return this.getPlayer().openEnchanting(arg0, arg1);
	}

	public InventoryView openInventory(Inventory arg0) {
		return this.getPlayer().openInventory(arg0);
	}

	public void openInventory(InventoryView arg0) {
		this.getPlayer().openInventory(arg0);
	}

	public InventoryView openWorkbench(Location arg0, boolean arg1) {
		return this.getPlayer().openWorkbench(arg0, arg1);
	}

	public void setGameMode(GameMode arg0) {
		this.getPlayer().setGameMode(arg0);
	}

	public void setItemInHand(ItemStack arg0) {
		this.getPlayer().setItemInHand(arg0);
	}

	public void setItemOnCursor(ItemStack arg0) {
		this.getPlayer().setItemOnCursor(arg0);
	}

	public boolean setWindowProperty(Property arg0, int arg1) {
		return this.getPlayer().setWindowProperty(arg0, arg1);
	}

	public boolean addPotionEffect(PotionEffect arg0) {
		return this.getPlayer().addPotionEffect(arg0);
	}

	public boolean addPotionEffect(PotionEffect arg0, boolean arg1) {
		return this.getPlayer().addPotionEffect(arg0, arg1);
	}

	public boolean addPotionEffects(Collection<PotionEffect> arg0) {
		return this.getPlayer().addPotionEffects(arg0);
	}

	public Collection<PotionEffect> getActivePotionEffects() {
		return this.getPlayer().getActivePotionEffects();
	}

	public boolean getCanPickupItems() {
		return this.getPlayer().getCanPickupItems();
	}

	public String getCustomName() {
		return this.getPlayer().getCustomName();
	}

	public EntityEquipment getEquipment() {
		return this.getPlayer().getEquipment();
	}

	public double getEyeHeight() {
		return this.getPlayer().getEyeHeight();
	}

	public double getEyeHeight(boolean arg0) {
		return this.getPlayer().getEyeHeight(arg0);
	}

	public Location getEyeLocation() {
		return this.getPlayer().getEyeLocation();
	}

	public Player getKiller() {
		return this.getPlayer().getKiller();
	}

	@Deprecated
	public List<Block> getLastTwoTargetBlocks(HashSet<Byte> arg0, int arg1) {
		return this.getPlayer().getLastTwoTargetBlocks(arg0, arg1);
	}

	public Entity getLeashHolder() throws IllegalStateException {
		return this.getPlayer().getLeashHolder();
	}

	@Deprecated
	public List<Block> getLineOfSight(HashSet<Byte> arg0, int arg1) {
		return this.getPlayer().getLineOfSight(arg0, arg1);
	}

	public int getMaximumAir() {
		return this.getPlayer().getMaximumAir();
	}

	public int getMaximumNoDamageTicks() {
		return this.getPlayer().getMaximumNoDamageTicks();
	}

	public int getNoDamageTicks() {
		return this.getPlayer().getNoDamageTicks();
	}

	public int getRemainingAir() {
		return this.getPlayer().getRemainingAir();
	}

	public boolean getRemoveWhenFarAway() {
		return this.getPlayer().getRemoveWhenFarAway();
	}

	@Deprecated
	public Block getTargetBlock(HashSet<Byte> arg0, int arg1) {
		return this.getPlayer().getTargetBlock(arg0, arg1);
	}

	public boolean hasLineOfSight(Entity arg0) {
		return this.getPlayer().hasLineOfSight(arg0);
	}

	public boolean hasPotionEffect(PotionEffectType arg0) {
		return this.getPlayer().hasPotionEffect(arg0);
	}

	public boolean isCustomNameVisible() {
		return this.getPlayer().isCustomNameVisible();
	}

	public boolean isLeashed() {
		return this.getPlayer().isLeashed();
	}

	public <T extends Projectile> T launchProjectile(Class<? extends T> arg0) {
		return this.getPlayer().launchProjectile(arg0);
	}

	public void removePotionEffect(PotionEffectType arg0) {
		this.getPlayer().removePotionEffect(arg0);
	}

	public void setCanPickupItems(boolean arg0) {
		this.getPlayer().setCanPickupItems(arg0);
	}

	public void setCustomName(String arg0) {
		this.getPlayer().setCustomName(arg0);
	}

	public void setCustomNameVisible(boolean arg0) {
		this.getPlayer().setCustomNameVisible(arg0);
	}

	public void setLastDamage(double arg0) {
		this.getPlayer().setLastDamage(arg0);
	}

	public boolean setLeashHolder(Entity arg0) {
		return this.getPlayer().setLeashHolder(arg0);
	}

	public void setMaximumAir(int arg0) {
		this.getPlayer().setMaximumAir(arg0);
	}

	public void setMaximumNoDamageTicks(int arg0) {
		this.getPlayer().setMaximumNoDamageTicks(arg0);
	}

	public void setNoDamageTicks(int arg0) {
		this.getPlayer().setNoDamageTicks(arg0);
	}

	public void setRemainingAir(int arg0) {
		this.getPlayer().setRemainingAir(arg0);
	}

	public void setRemoveWhenFarAway(boolean arg0) {
		this.getPlayer().setRemoveWhenFarAway(arg0);
	}

	@Deprecated
	public Arrow shootArrow() {
		return this.getPlayer().shootArrow();
	}

	@Deprecated
	public Egg throwEgg() {
		return this.getPlayer().throwEgg();
	}

	@Deprecated
	public Snowball throwSnowball() {
		return this.getPlayer().throwSnowball();
	}

	public boolean eject() {
		return this.getPlayer().eject();
	}

	public int getEntityId() {
		return this.getPlayer().getEntityId();
	}

	public float getFallDistance() {
		return this.getPlayer().getFallDistance();
	}

	public int getFireTicks() {
		return this.getPlayer().getFireTicks();
	}

	public EntityDamageEvent getLastDamageCause() {
		return this.getPlayer().getLastDamageCause();
	}

	public Location getLocation() {
		return this.getPlayer().getLocation();
	}

	public Location getLocation(Location arg0) {
		return this.getPlayer().getLocation(arg0);
	}

	public int getMaxFireTicks() {
		return this.getPlayer().getMaxFireTicks();
	}

	public List<Entity> getNearbyEntities(double arg0, double arg1, double arg2) {
		return this.getPlayer().getNearbyEntities(arg0, arg1, arg2);
	}

	public Entity getPassenger() {
		return this.getPlayer().getPassenger();
	}

	public Server getServer() {
		return this.getPlayer().getServer();
	}

	public int getTicksLived() {
		return this.getPlayer().getTicksLived();
	}

	public EntityType getType() {
		return this.getPlayer().getType();
	}

	public UUID getUniqueId() {
		return this.uuid;
	}

	public Entity getVehicle() {
		return this.getPlayer().getVehicle();
	}

	public Vector getVelocity() {
		return this.getPlayer().getVelocity();
	}

	public World getWorld() {
		return this.getPlayer().getWorld();
	}

	public boolean isDead() {
		return this.getPlayer().isDead();
	}

	public boolean isEmpty() {
		return this.getPlayer().isEmpty();
	}

	public boolean isInsideVehicle() {
		return this.getPlayer().isInsideVehicle();
	}

	public boolean isValid() {
		return this.getPlayer().isValid();
	}

	public boolean leaveVehicle() {
		return this.getPlayer().leaveVehicle();
	}

	public void playEffect(EntityEffect arg0) {
		this.getPlayer().playEffect(arg0);
	}

	public void remove() {
		this.getPlayer().remove();
	}

	public void setFallDistance(float arg0) {
		this.getPlayer().setFallDistance(arg0);
	}

	public void setFireTicks(int arg0) {
		this.getPlayer().setFireTicks(arg0);
	}

	public void setLastDamageCause(EntityDamageEvent arg0) {
		this.getPlayer().setLastDamageCause(arg0);
	}

	public boolean setPassenger(Entity arg0) {
		return this.getPlayer().setPassenger(arg0);
	}

	public void setTicksLived(int arg0) {
		this.getPlayer().setTicksLived(arg0);
	}

	public void setVelocity(Vector arg0) {
		this.getPlayer().setVelocity(arg0);
	}

	public boolean teleport(Location arg0) {
		return this.getPlayer().teleport(arg0);
	}

	public boolean teleport(Entity arg0) {
		return this.getPlayer().teleport(arg0);
	}

	public boolean teleport(Location arg0, TeleportCause arg1) {
		return this.getPlayer().teleport(arg0, arg1);
	}

	public boolean teleport(Entity arg0, TeleportCause arg1) {
		return false;
	}

	public List<MetadataValue> getMetadata(String arg0) {
		return this.getPlayer().getMetadata(arg0);
	}

	public boolean hasMetadata(String arg0) {
		return this.getPlayer().hasMetadata(arg0);
	}

	public void removeMetadata(String arg0, Plugin arg1) {
		this.getPlayer().removeMetadata(arg0, arg1);
	}

	public void setMetadata(String arg0, MetadataValue arg1) {
		this.getPlayer().setMetadata(arg0, arg1);
	}

	public void damage(double arg0) {
		this.getPlayer().damage(arg0);
	}

	public void damage(double arg0, Entity arg1) {
		this.getPlayer().damage(arg0, arg1);
	}

	public void resetMaxHealth() {
		this.getPlayer().resetMaxHealth();
	}

	public void setHealth(double arg0) {
		this.getPlayer().setHealth(arg0);
	}

	public void setMaxHealth(double arg0) {
		this.getPlayer().setMaxHealth(arg0);
	}

	public PermissionAttachment addAttachment(Plugin arg0) {
		return this.getPlayer().addAttachment(arg0);
	}

	public PermissionAttachment addAttachment(Plugin arg0, int arg1) {
		return this.getPlayer().addAttachment(arg0, arg1);
	}

	public PermissionAttachment addAttachment(Plugin arg0, String arg1, boolean arg2) {
		return this.getPlayer().addAttachment(arg0, arg1, arg2);
	}

	public PermissionAttachment addAttachment(Plugin arg0, String arg1, boolean arg2, int arg3) {
		return this.getPlayer().addAttachment(arg0, arg1, arg2, arg3);
	}

	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		return this.getPlayer().getEffectivePermissions();
	}

	public boolean hasPermission(String arg0) {
		return this.getPlayer().hasPermission(arg0);
	}

	public boolean hasPermission(Permission arg0) {
		return this.getPlayer().hasPermission(arg0);
	}

	public boolean isPermissionSet(String arg0) {
		return this.getPlayer().isPermissionSet(arg0);
	}

	public boolean isPermissionSet(Permission arg0) {
		return this.getPlayer().isPermissionSet(arg0);
	}

	public void recalculatePermissions() {
		this.getPlayer().recalculatePermissions();
	}

	public void removeAttachment(PermissionAttachment arg0) {
		this.getPlayer().removeAttachment(arg0);
	}

	public boolean isOp() {
		return this.getPlayer().isOp();
	}

	public void setOp(boolean arg0) {
		this.getPlayer().setOp(arg0);
	}

	public void abandonConversation(Conversation arg0) {
		this.getPlayer().abandonConversation(arg0);
	}

	public void abandonConversation(Conversation arg0, ConversationAbandonedEvent arg1) {
		this.getPlayer().abandonConversation(arg0, arg1);
	}

	public void acceptConversationInput(String arg0) {
		this.getPlayer().acceptConversationInput(arg0);
	}

	public boolean beginConversation(Conversation arg0) {
		return this.getPlayer().beginConversation(arg0);
	}

	public boolean isConversing() {
		return this.getPlayer().isConversing();
	}

	public void sendMessage(String arg0) {
		this.getPlayer().sendMessage(arg0);
	}

	public void sendMessage(String[] arg0) {
		this.getPlayer().sendMessage(arg0);
	}

	public long getFirstPlayed() {
		return this.getPlayer().getFirstPlayed();
	}

	public long getLastPlayed() {
		return this.getPlayer().getLastPlayed();
	}

	public boolean hasPlayedBefore() {
		return this.getPlayer().hasPlayedBefore();
	}

	public boolean isBanned() {
		return this.getPlayer().isBanned();
	}

	public boolean isOnline() {
		return this.getPlayer().isOnline();
	}

	public boolean isWhitelisted() {
		return this.getPlayer().isWhitelisted();
	}

	public void setWhitelisted(boolean arg0) {
		this.getPlayer().setWhitelisted(arg0);
	}

	public Map<String, Object> serialize() {
		return this.getPlayer().serialize();
	}

	public Set<String> getListeningPluginChannels() {
		return this.getPlayer().getListeningPluginChannels();
	}

	public void sendPluginMessage(Plugin arg0, String arg1, byte[] arg2) {
		this.getPlayer().sendPluginMessage(arg0, arg1, arg2);
	}

	public void awardAchievement(Achievement arg0) {
		this.getPlayer().awardAchievement(arg0);
	}

	public boolean getAllowFlight() {
		return this.getPlayer().getAllowFlight();
	}

	public Location getBedSpawnLocation() {
		return this.getPlayer().getBedSpawnLocation();
	}

	public float getExhaustion() {
		return this.getPlayer().getExhaustion();
	}

	public float getExp() {
		return this.getPlayer().getExp();
	}

	public float getFlySpeed() {
		return this.getPlayer().getFlySpeed();
	}

	public int getFoodLevel() {
		return this.getPlayer().getFoodLevel();
	}

	public double getHealthScale() {
		return this.getPlayer().getHealthScale();
	}

	public int getLevel() {
		return this.getPlayer().getLevel();
	}

	public long getPlayerTime() {
		return this.getPlayer().getPlayerTime();
	}

	public long getPlayerTimeOffset() {
		return this.getPlayer().getPlayerTimeOffset();
	}

	public WeatherType getPlayerWeather() {
		return this.getPlayer().getPlayerWeather();
	}

	public float getSaturation() {
		return this.getPlayer().getSaturation();
	}

	public Scoreboard getScoreboard() {
		return this.getPlayer().getScoreboard();
	}

	public int getTotalExperience() {
		return this.getPlayer().getTotalExperience();
	}

	public float getWalkSpeed() {
		return this.getPlayer().getWalkSpeed();
	}

	public void giveExp(int arg0) {
		this.getPlayer().giveExp(arg0);
	}

	public void giveExpLevels(int arg0) {
		this.getPlayer().giveExpLevels(arg0);
	}

	public void incrementStatistic(Statistic arg0) {
		this.getPlayer().incrementStatistic(arg0);
	}

	public void incrementStatistic(Statistic arg0, int arg1) {
		this.getPlayer().incrementStatistic(arg0, arg1);
	}

	public void incrementStatistic(Statistic arg0, Material arg1) {
		this.getPlayer().incrementStatistic(arg0, arg1);
	}

	public void incrementStatistic(Statistic arg0, Material arg1, int arg2) {
		this.getPlayer().incrementStatistic(arg0, arg1, arg2);
	}

	public boolean isFlying() {
		return this.getPlayer().isFlying();
	}

	public boolean isHealthScaled() {
		return this.getPlayer().isHealthScaled();
	}

	@Deprecated
	public boolean isOnGround() {
		return this.getPlayer().isOnGround();
	}

	public boolean isPlayerTimeRelative() {
		return this.getPlayer().isPlayerTimeRelative();
	}

	public boolean isSleepingIgnored() {
		return this.getPlayer().isSleepingIgnored();
	}

	public boolean isSprinting() {
		return this.getPlayer().isSprinting();
	}

	public void loadData() {
		this.getPlayer().loadData();
	}

	@Deprecated
	public void playEffect(Location arg0, Effect arg1, int arg2) {
		this.getPlayer().playEffect(arg0, arg1, arg2);
	}

	public <T> void playEffect(Location arg0, Effect arg1, T arg2) {
		this.getPlayer().playEffect(arg0, arg1, arg2);
	}

	@Deprecated
	public void playNote(Location arg0, byte arg1, byte arg2) {
		this.getPlayer().playNote(arg0, arg1, arg2);
	}

	public void playNote(Location arg0, Instrument arg1, Note arg2) {
		this.getPlayer().playNote(arg0, arg1, arg2);
	}

	public void playSound(Location arg0, Sound arg1, float arg2, float arg3) {
		this.getPlayer().playSound(arg0, arg1, arg2, arg3);
	}

	@Deprecated
	public void playSound(Location arg0, String arg1, float arg2, float arg3) {
		this.getPlayer().playSound(arg0, arg1, arg2, arg3);
	}

	public void resetPlayerTime() {
		this.getPlayer().resetPlayerTime();
	}

	public void resetPlayerWeather() {
		this.getPlayer().resetPlayerWeather();
	}

	public void saveData() {
		this.getPlayer().saveData();
	}

	@Deprecated
	public void sendBlockChange(Location arg0, Material arg1, byte arg2) {
		this.getPlayer().sendBlockChange(arg0, arg1, arg2);
	}

	@Deprecated
	public void sendBlockChange(Location arg0, int arg1, byte arg2) {
		this.getPlayer().sendBlockChange(arg0, arg1, arg2);
	}

	@Deprecated
	public boolean sendChunkChange(Location arg0, int arg1, int arg2, int arg3, byte[] arg4) {
		return this.getPlayer().sendChunkChange(arg0, arg1, arg2, arg3, arg4);
	}

	public void sendMap(MapView arg0) {
		this.getPlayer().sendMap(arg0);
	}

	public void setAllowFlight(boolean arg0) {
		this.getPlayer().setAllowFlight(arg0);
	}

	public void setBedSpawnLocation(Location arg0) {
		this.getPlayer().setBedSpawnLocation(arg0);
	}

	public void setBedSpawnLocation(Location arg0, boolean arg1) {
		this.getPlayer().setBedSpawnLocation(arg0);
	}

	public void setCompassTarget(Location arg0) {
		this.getPlayer().setCompassTarget(arg0);
	}

	public void setExhaustion(float arg0) {
		this.getPlayer().setExhaustion(arg0);
	}

	public void setExp(float arg0) {
		this.getPlayer().setExp(arg0);
	}

	public void setFlySpeed(float arg0) throws IllegalArgumentException {
		this.getPlayer().setFlySpeed(arg0);
	}

	public void setFlying(boolean arg0) {
		this.getPlayer().setFlying(arg0);
	}

	public void setFoodLevel(int arg0) {
		this.getPlayer().setFoodLevel(arg0);
	}

	public void setHealthScale(double arg0) throws IllegalArgumentException {
		this.getPlayer().setHealthScale(arg0);
	}

	public void setHealthScaled(boolean arg0) {
		this.getPlayer().setHealthScaled(arg0);
	}

	public void setLevel(int arg0) {
		this.getPlayer().setLevel(arg0);
	}

	public void setPlayerTime(long arg0, boolean arg1) {
		this.getPlayer().setPlayerTime(arg0, arg1);
	}

	public void setPlayerWeather(WeatherType arg0) {
		this.getPlayer().setPlayerWeather(arg0);
	}

	public void setSaturation(float arg0) {
		this.getPlayer().setSaturation(arg0);
	}

	public void setScoreboard(Scoreboard arg0) throws IllegalArgumentException, IllegalStateException {
		this.getPlayer().setScoreboard(arg0);
	}

	public void setSleepingIgnored(boolean arg0) {
		this.getPlayer().setSleepingIgnored(arg0);
	}

	public void setSneaking(boolean arg0) {
		this.getPlayer().setSneaking(arg0);
	}

	public void setSprinting(boolean arg0) {
		this.getPlayer().setSprinting(arg0);
	}

	@Deprecated
	public void setTexturePack(String arg0) {
		this.getPlayer().setTexturePack(arg0);
	}

	public void setTotalExperience(int arg0) {
		this.getPlayer().setTotalExperience(arg0);
	}

	public void setWalkSpeed(float arg0) throws IllegalArgumentException {
		this.getPlayer().setWalkSpeed(arg0);
	}

	@Deprecated
	public void updateInventory() {
		this.getPlayer().updateInventory();
	}

	public boolean canSee(Player arg0) {
		return this.getPlayer().canSee(arg0);
	}

	public void hidePlayer(Player arg0) {
		this.getPlayer().hidePlayer(arg0);
	}

	public void setResourcePack(String arg0) {
		this.getPlayer().setResourcePack(arg0);
	}

	public void showPlayer(Player arg0) {
		this.getPlayer().showPlayer(arg0);
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
		return this.getPlayer().launchProjectile(arg0, arg1);
	}

	@Override
	public void setBanned(boolean arg0) {

	}

	@Override
	public void decrementStatistic(Statistic arg0) throws IllegalArgumentException {
		this.getPlayer().decrementStatistic(arg0);
	}

	@Override
	public void decrementStatistic(Statistic arg0, int arg1) throws IllegalArgumentException {
		this.getPlayer().decrementStatistic(arg0, arg1);
	}

	@Override
	public void decrementStatistic(Statistic arg0, Material arg1) throws IllegalArgumentException {
		this.getPlayer().decrementStatistic(arg0, arg1);
	}

	@Override
	public void decrementStatistic(Statistic arg0, EntityType arg1) throws IllegalArgumentException {
		this.getPlayer().decrementStatistic(arg0, arg1);
	}

	@Override
	public void decrementStatistic(Statistic arg0, Material arg1, int arg2) throws IllegalArgumentException {
		this.getPlayer().decrementStatistic(arg0, arg1, arg2);
	}

	@Override
	public void decrementStatistic(Statistic arg0, EntityType arg1, int arg2) {
		this.getPlayer().decrementStatistic(arg0, arg1, arg2);
	}

	@Override
	public int getStatistic(Statistic arg0) throws IllegalArgumentException {
		return this.getPlayer().getStatistic(arg0);
	}

	@Override
	public int getStatistic(Statistic arg0, Material arg1) throws IllegalArgumentException {
		return this.getPlayer().getStatistic(arg0, arg1);
	}

	@Override
	public int getStatistic(Statistic arg0, EntityType arg1) throws IllegalArgumentException {
		return this.getPlayer().getStatistic(arg0, arg1);
	}

	@Override
	public boolean hasAchievement(Achievement arg0) {
		return this.getPlayer().hasAchievement(arg0);
	}

	@Override
	public void incrementStatistic(Statistic arg0, EntityType arg1) throws IllegalArgumentException {
		this.getPlayer().incrementStatistic(arg0, arg1);
	}

	@Override
	public void incrementStatistic(Statistic arg0, EntityType arg1, int arg2) throws IllegalArgumentException {
		this.getPlayer().incrementStatistic(arg0, arg1, arg2);
	}

	@Override
	public void removeAchievement(Achievement arg0) {
		this.getPlayer().removeAchievement(arg0);
	}

	@Override
	public void setStatistic(Statistic arg0, int arg1) throws IllegalArgumentException {
		this.getPlayer().setStatistic(arg0, arg1);
	}

	@Override
	public void setStatistic(Statistic arg0, Material arg1, int arg2) throws IllegalArgumentException {
		this.getPlayer().setStatistic(arg0, arg1, arg2);
	}

	@Override
	public void setStatistic(Statistic arg0, EntityType arg1, int arg2) {
		this.getPlayer().setStatistic(arg0, arg1, arg2);
	}

}