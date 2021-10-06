
#include "CoronaEvent.h"
#include "CoronaLua.h"

int lib_init( lua_State *L ) {
    lua_pushvalue(L, 1);
    CoronaLuaNewEvent(L, "library");
    lua_pushliteral(L, "Hello World!");
    lua_setfield(L, -2, "message");
    lua_pcall(L, 1, 0, 0);
    return 0;
}

int lib_show( lua_State *L ) {
    
    return 0;
}

CORONA_EXPORT
int luaopen_plugin_library( lua_State *L )
{
    static const luaL_Reg kVTable[] = {
        { "init", lib_init },
        { "show", lib_show },
        { NULL, NULL }
    };

    luaL_openlib( L, "plugin.library", kVTable, 0 );

    return 1;
}