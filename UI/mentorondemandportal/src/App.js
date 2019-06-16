import React from 'react';
import PropTypes from 'prop-types';
import './App.css';

import { withStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Drawer from '@material-ui/core/Drawer';
import Typography from '@material-ui/core/Typography';
import IconButton from '@material-ui/core/IconButton';
import MenuIcon from '@material-ui/icons/Menu';
import PersonIcon from '@material-ui/icons/Person';
import { Link, Route, Switch } from 'react-router-dom';

import Divider from '@material-ui/core/Divider';

import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import ReceiptIcon from '@material-ui/icons/Receipt';
import PaymentIcon from '@material-ui/icons/Payment';

import AuthRoute from './components/AuthRoute';
import UserManagement from './components/UserManagement';
import MentorSearch from './components/MentorSearch';
import Proposals from './components/Proposals';
import Payments from './components/Payments';

class App extends React.Component {
  state = {
    isLoggedIn: false,
    userProfile: {},
    isDrawerOpen: false
  };

  handleUserClick = () => {};
  handleLoginClick = (userName, password, isMentor) => {
    const userType = isMentor ? 'mentors' : 'users';
    const userNameType = isMentor ? 'mentorEmail' : 'username';

    fetch(
      `http://localhost:3001/${userType}?${userNameType}=${userName}&password=${password}`
    )
      .then(res => res.json())
      .then(resp => {
        if (resp.length === 1) {
          this.setState({
            userProfile: resp[0],
            isLoggedIn: true
          });
        }
      });
  };

  handleMenuClick = () => {
    if (this.state.userProfile) {
    }
    this.setState({
      isDrawerOpen: !this.state.isDrawerOpen
    });
  };
  render() {
    const { classes } = this.props;

    return (
      <div className="App">
        <AppBar position="static">
          <Toolbar>
            <div className="left-content">
              <IconButton
                className={classes.menuButton}
                color="inherit"
                aria-label="Menu"
                onClick={this.handleMenuClick}
              >
                <MenuIcon />
              </IconButton>
              <Typography
                variant="title"
                color="inherit"
                className={classes.flex}
              >
                <Link to="/">Mentor On Demand</Link>
              </Typography>
            </div>
            <IconButton
              className={classes.personButton}
              color="inherit"
              aria-label="Sign In"
            >
              <Link to="/user">
                <PersonIcon />
              </Link>
            </IconButton>
          </Toolbar>
        </AppBar>
        <Drawer open={this.state.isDrawerOpen} onClose={this.handleMenuClick}>
          <List component="nav">
            <ListItem button onClick={this.handleMenuClick}>
              <ListItemIcon>
                <PersonIcon />
              </ListItemIcon>
              <Link to="/user">
                <ListItemText primary={this.state.userProfile.name} />
              </Link>
            </ListItem>
          </List>
          <Divider />
          <div tabIndex={0} role="button" onClick={this.handleMenuClick}>
            <List component="nav">
              <Link to="/proposals">
                <ListItem button>
                  <ListItemIcon>
                    <ReceiptIcon />
                  </ListItemIcon>
                  <ListItemText primary="Proposals" />
                </ListItem>
              </Link>
              <Link to="/payments">
                <ListItem button>
                  <ListItemIcon>
                    <PaymentIcon />
                  </ListItemIcon>
                  <ListItemText primary="Payments" />
                </ListItem>
              </Link>
            </List>
          </div>
        </Drawer>
        <Switch>
          <Route
            exact
            path="/user"
            render={() => (
              <UserManagement
                isLoggedIn={this.state.isLoggedIn}
                userProfile={this.state.userProfile}
                handleLoginClick={this.handleLoginClick}
              />
            )}
          />
          <AuthRoute
            path="/"
            exact
            isLoggedIn={this.state.isLoggedIn}
            component={MentorSearch}
            userProfile={this.state.userProfile}
          />
          <AuthRoute
            path="/proposals"
            isLoggedIn={this.state.isLoggedIn}
            component={Proposals}
            userProfile={this.state.userProfile}
          />
          <AuthRoute
            path="/payments"
            isLoggedIn={this.state.isLoggedIn}
            component={Payments}
            userProfile={this.state.userProfile}
          />
        </Switch>
      </div>
    );
  }
}

App.propTypes = {
  classes: PropTypes.object.isRequired
};

export default withStyles(() => {})(App);
