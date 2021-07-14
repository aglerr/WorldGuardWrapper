package me.aglerr.worldguardwrapper.wrapper;

import me.aglerr.worldguardwrapper.regions.IRegionFinder;

public class WorldGuardWrapper {

    private static WorldGuardWrapper instance;

    public static WorldGuardWrapper getInstance(){
        if(instance == null){
            instance = new WorldGuardWrapper();
        }
        return instance;
    }

    private final IRegionFinder regionFinder;

    private WorldGuardWrapper(){
        int apiVersion;
        try{
            Class.forName("com.sk89q.worldguard.WorldGuard");
            apiVersion = 7;
        } catch (ClassNotFoundException ex){
            apiVersion = 6;
        }
        if(apiVersion == 6){
            regionFinder = new me.aglerr.worldguardwrapper.wgsix.RegionFinder();
        } else {
            regionFinder = new me.aglerr.worldguardwrapper.wgseven.RegionFinder();
        }
    }

    public IRegionFinder getRegionFinder() {
        return regionFinder;
    }

}
