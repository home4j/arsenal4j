import React from 'react';
import {render} from 'react-dom';
import injectTapEventPlugin from 'react-tap-event-plugin';

import AppBar from 'material-ui/AppBar';
import getMuiTheme from 'material-ui/styles/getMuiTheme';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import NavigationMenu from 'material-ui/svg-icons/navigation/menu';
import IconButton from 'material-ui/IconButton';

injectTapEventPlugin();
const muiTheme = getMuiTheme();

// 图表列表查看，https://materialdesignicons.com/

const AppBarExampleIcon = () => (
    <AppBar
        title="Title"
        iconElementLeft={<IconButton><NavigationMenu /></IconButton>}
    />
);

render(
    <MuiThemeProvider muiTheme={muiTheme}>
        <AppBarExampleIcon />
    </MuiThemeProvider>
    , document.getElementById('app'));