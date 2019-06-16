import React from 'react';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import Checkbox from '@material-ui/core/Checkbox';
import FormControlLabel from '@material-ui/core/FormControlLabel';

export default class UserManagement extends React.Component {
  state = {
    userName: '',
    password: '',
    isMentor: false
  };
  handleChange = name => event => {
    if (name === 'isMentor') {
      this.setState({ ...this.state, [name]: event.target.checked });
    } else {
      this.setState({ ...this.state, [name]: event.target.value });
    }
  };

  render() {
    const { isLoggedIn } = this.props;
    return (
      <div className="user-management-container">
        {isLoggedIn ? (
          <h1>user is logged in</h1>
        ) : (
          <div className="login">
            <h2 className="route-header">Log in to Mentor On Demand</h2>
            <TextField
              id="userId"
              label="User ID"
              // className={classes.textField}
              value={this.state.userName}
              onChange={this.handleChange('userName')}
              margin="normal"
              fullWidth
            />
            <TextField
              id="password-input"
              label="Password"
              // className={classes.textField}
              type="password"
              autoComplete="current-password"
              margin="normal"
              onChange={this.handleChange('password')}
              fullWidth
            />
            <FormControlLabel
              control={
                <Checkbox
                  checked={this.state.isMentor}
                  onChange={this.handleChange('isMentor')}
                  value="isMentor"
                  color="primary"
                  inputProps={{
                    'aria-label': 'Mentor Login'
                  }}
                />
              }
              label="Mentor Login"
            />

            <div className="button-wrapper">
              <Button
                variant="contained"
                color="primary"
                onClick={() =>
                  this.props.handleLoginClick(
                    this.state.userName,
                    this.state.password,
                    this.state.isMentor
                  )
                }
              >
                Log In
              </Button>
            </div>
          </div>
        )}
      </div>
    );
  }
}
