"use strict";

import React from 'react';
import {render} from 'react-dom';
import {
    Step,
    Stepper,
    StepButton,
    StepContent,
} from 'material-ui/Stepper';
import RaisedButton from 'material-ui/RaisedButton';
import FlatButton from 'material-ui/FlatButton';

import getMuiTheme from 'material-ui/styles/getMuiTheme';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';

/**
 * A basic vertical non-linear implementation
 */
class VerticalNonLinear extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            stepIndex: 0
        };
    }

    handleNext() {
        const {stepIndex} = this.state;
        console.log(this.state);
        if (stepIndex < 2) {
            this.setState({stepIndex: stepIndex + 1});
        }
    }

    handlePrev() {
        const {stepIndex} = this.state;
        if (stepIndex > 0) {
            this.setState({stepIndex: stepIndex - 1});
        }
    }

    renderStepActions(step) {
        return (
            <div style={{margin: '12px 0'}}>
                <RaisedButton
                    label="Next"
                    disableTouchRipple={true}
                    disableFocusRipple={true}
                    primary={true}
                    onMouseUp={this.handleNext.bind(this)} // 需要绑定到上下文中，否则在回调函数内会取不到正确的this
                    style={{marginRight: 12}}
                />
                {step > 0 && (
                    <FlatButton
                        label="Back"
                        disableTouchRipple={true}
                        disableFocusRipple={true}
                        onMouseUp={this.handlePrev.bind(this)}
                    />
                )}
            </div>
        );
    }

    render() {
        const {stepIndex} = this.state;

        return (
            <div style={{width: 380, height: 400, margin: 'auto'}}>
                <Stepper
                    activeStep={stepIndex}
                    linear={false}
                    orientation="vertical"
                >
                    <Step>

                        <StepButton onClick={
                            // 此处需要使用匿名函数为了传入正确的参数
                            () => this.setState({stepIndex: 0}
                            )}>
                            Select campaign settings
                        </StepButton>
                        <StepContent>
                            <p>
                                For each ad campaign that you create, you can control how much
                                you're willing to spend on clicks and conversions, which networks
                                and geographical locations you want your ads to show on, and more.
                            </p>
                            {this.renderStepActions(0)}
                        </StepContent>
                    </Step>
                    <Step>
                        <StepButton onClick={() => this.setState({stepIndex: 1})}>
                            Create an ad group
                        </StepButton>
                        <StepContent>
                            <p>An ad group contains one or more ads which target a shared set of keywords.</p>
                            {this.renderStepActions(1)}
                        </StepContent>
                    </Step>
                    <Step>
                        <StepButton onClick={() => this.setState({stepIndex: 2})}>
                            Create an ad
                        </StepButton>
                        <StepContent>
                            <p>
                                Try out different ad text to see what brings in the most customers,
                                and learn how to enhance your ads using features like ad extensions.
                                If you run into any problems with your ads, find out how to tell if
                                they're running and how to resolve approval issues.
                            </p>
                            {this.renderStepActions(2)}
                        </StepContent>
                    </Step>
                </Stepper>
            </div>
        );
    }
}

render(
    <MuiThemeProvider muiTheme={getMuiTheme()}>
        <VerticalNonLinear />
    </MuiThemeProvider>
    , document.getElementById('app'));