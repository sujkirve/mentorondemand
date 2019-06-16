import React from 'react';
import { Route, Redirect } from 'react-router-dom';

export default function AuthRoute({
  component: Component,
  isLoggedIn,
  ...rest
}) {
  console.log(rest);
  return (
    <Route
      {...rest}
      render={props =>
        isLoggedIn === true ? (
          <Component {...props} {...rest}/>
        ) : (
          <Redirect
            to={{ pathname: '/user', state: { from: props.location } }}
          />
        )
      }
    />
  );
}
